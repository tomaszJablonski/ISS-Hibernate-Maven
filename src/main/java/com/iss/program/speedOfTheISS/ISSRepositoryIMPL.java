package com.iss.program.speedOfTheISS;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@RequiredArgsConstructor
public class ISSRepositoryIMPL implements ISSRepository {

    private final SessionFactory sessionFactory;

    @Override
    public ISSLocation save(ISSLocation issLocation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(issLocation);

        transaction.commit();
        session.close();
        return issLocation;
    }
}
