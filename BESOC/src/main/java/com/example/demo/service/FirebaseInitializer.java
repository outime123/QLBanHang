package com.example.demo.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {
	
	@PostConstruct
	private void initDB()throws IOException {
		InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./dbsoc-2ff1d-firebase-adminsdk-6ouco-4daddd4328.json");
				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("firebase-adminsdk-6ouco@dbsoc-2ff1d.iam.gserviceaccount.com")
				  .build();

				FirebaseApp.initializeApp(options);
				if(FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}
	}
	
	public Firestore getFirestore() {
		return FirestoreClient.getFirestore();
	}
}