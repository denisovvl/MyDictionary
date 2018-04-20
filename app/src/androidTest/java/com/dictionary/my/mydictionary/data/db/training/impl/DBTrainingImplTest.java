package com.dictionary.my.mydictionary.data.db.training.impl;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Test for DBTrainingImpl class
 */
@RunWith(Parameterized.class)
public class DBTrainingImplTest {

    DBTrainingImpl db;
    @Parameterized.Parameters
    public static Collection<Object[]> numbers(){
        ArrayList<Long> del = new ArrayList<>();
        ArrayList<Long> exp = new ArrayList<>();
        del.add(5L);
        del.add(7L);
        del.add(9L);
        for(int i = 0; i < 20; i++){
            exp.add(Long.valueOf(i));
        }
        exp.remove(5L);
        exp.remove(7L);
        exp.remove(9L);

        ArrayList<Long> del2 = new ArrayList<>(del);
        del2.add(11L);
        del2.add(13L);
        del2.add(14L);
        ArrayList<Long> exp2 = new ArrayList<>(exp);
        exp2.remove(11L);
        exp2.remove(13L);
        exp2.remove(14L);

        ArrayList<Long> del3 = new ArrayList<>(del2);
        del3.add(16L);
        del3.add(18L);
        del3.add(19L);
        ArrayList<Long> exp3 = new ArrayList<>(exp2);
        exp3.remove(16L);
        exp3.remove(18L);
        exp3.remove(19L);
        ArrayList<Long> del4 = new ArrayList<>();
        for(int i = 0; i < 19; i++){
            del4.add(Long.valueOf(i));
        }
        ArrayList<Long> exp4 = new ArrayList<>();
        exp4.add(20L);
        return Arrays.asList(new Object[][]{
                {del,exp},
                {del2,exp2},
                {del3,exp3},
                {del4,exp4}
        });
    }

    ArrayList<Long> del = null;
    ArrayList<Long> exp = null;
    public DBTrainingImplTest(ArrayList<Long> del, ArrayList<Long> exp){
        this.del = del;
        this.exp = exp;
    }

    @Before
    public void init(){
        // Context of the app under test.
        Context context = InstrumentationRegistry.getTargetContext();
        db = new DBTrainingImpl(context);

    }

    @Test
    public void setWordsToEngRusTraining(){
        db.setWordsToTraining(exp,1);
        ArrayList<Long> output = db.getWordsFromTraining(1);
        assertEquals(exp,output);
    }
    @Test
    public void deleteWordsFromTraining(){
        db.deleteWordsFromTraining(del,1);
        ArrayList<Long> output  = db.getWordsFromTraining(1);
        assertEquals(exp,output);
    }
    @Test
    public void getWordsFromTraining(){
        db.setWordsToTraining(exp,1);
        ArrayList<Long> output = db.getWordsFromTraining(1);
        assertEquals(exp,output);
    }
    @Test
    public void getCountOfWordsFromTraining(){
        db.setWordsToTraining(exp,1);
        Integer count  = db.getWordsFromTraining(1).size();
        Integer expCount = exp.size();
        assertEquals(expCount,count);
    }


}