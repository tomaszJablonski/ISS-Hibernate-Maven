package com.iss;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iss.program.locationOfTheISS.ISSController;
import com.iss.program.locationOfTheISS.ISSMapper;
import com.iss.program.locationOfTheISS.ISSRepositoryIMPL;
import com.iss.program.locationOfTheISS.ISSService;
import com.iss.program.locationOfTheISS.client.ISSResponseMapper;
import com.iss.program.locationOfTheISS.client.IssClient;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IssApp {

    public static void main(String[] args) {

        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        ISSRepositoryIMPL issRepository = new ISSRepositoryIMPL(sessionFactory);
        ISSResponseMapper issResponseMapper = new ISSResponseMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        IssClient issClient = new IssClient(objectMapper, issResponseMapper);

        ISSService issService = new ISSService(issClient, issRepository);

        ISSMapper issMapper = new ISSMapper();
        ISSController issController = new ISSController(issMapper, objectMapper, issService);


        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner, issController);
        userInterface.runApplication();


    }
}