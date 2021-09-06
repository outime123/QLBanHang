package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class DBController {
	@Autowired
	FirebaseInitializer db = new FirebaseInitializer();
	@GetMapping("/getProductID/{ID}")
    public Product productByID(@PathVariable("ID") int ID) {
        return new Product();
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAll() throws InterruptedException, ExecutionException{
        List<Product> lp = new ArrayList<Product>();
        CollectionReference p = db.getFirestore().collection("Product");
        ApiFuture<QuerySnapshot> querySnapshot = p.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
            lp.add(doc.toObject(Product.class));
        }
        return lp;
    }

}
