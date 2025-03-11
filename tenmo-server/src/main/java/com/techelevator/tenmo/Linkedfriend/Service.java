package com.techelevator.tenmo.Linkedfriend;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

@org.springframework.stereotype.Service
public class Service {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToGoogleCredentials();

    private static String getPathToGoogleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePAth = Paths.get(currentDirectory, "aliouneCred.json");
        return filePAth.toString();
    }

    public Res uploadImageToDrive(File file) throws GeneralSecurityException, IOException {
        Res res = new Res();
        try {
            String folderId = "1gwWevOcBmPW4yz63ZTuBfWotAjdN22fb";
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(file.getName());
            fileMetaData.setParents(Collections.singletonList(folderId));
            FileContent mediaContent = new FileContent("image/jpeg", file);
            com.google.api.services.drive.model.File uploadFile = drive.files().create(fileMetaData, mediaContent).setFields("id").execute();
            String imageUrl = "https://dive.google.com/uc?export=view&id="+uploadFile.getId();
            file.delete();
            res.setStatus(200);
            res.setMessage("Alioune Diasse is here");
            res.setUrl(imageUrl);
        } catch (Exception e) {
            res.setStatus(540);

        }
        return res;
    }

    private Drive createDriveService() throws GeneralSecurityException, IOException {

        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH)).createScoped(Collections.singleton(DriveScopes.DRIVE));
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(),JSON_FACTORY,credential).build();
    }
}
