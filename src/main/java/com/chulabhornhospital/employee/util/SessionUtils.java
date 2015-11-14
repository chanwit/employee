package com.chulabhornhospital.employee.util;

import com.chulabhornhospital.employee.Main;
import org.apache.ibatis.session.SqlSession;

public class SessionUtils {

    public static interface Action {
        void execute(SqlSession session) throws Throwable;
    }

    public static interface Call<T> {
        T execute(SqlSession session) throws Throwable;
    }

    public static void with(Action action) throws Throwable {
        SqlSession session = null;
        try {
            session = Main.getFactory().openSession();
            action.execute(session);
        } catch (Throwable e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static <T> T withReturn(Call<T> action) throws Throwable {
        SqlSession session = null;
        try {
            session = Main.getFactory().openSession();
            return action.execute(session);
        } catch (Throwable e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public static <T> T withUpdate(Call<T> action) throws Throwable {
        SqlSession session = null;
        try {
            session = Main.getFactory().openSession();
            T result = action.execute(session);
            session.commit();
            return result;
        } catch (Throwable e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }


}
