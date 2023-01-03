package ru.org.impl;

import ru.org.IprService;
import ru.org.PropertyValues;
import ru.org.TaskIpr;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class IprServiceImpl implements IprService {
    private Logger logger = Logger.getLogger(IprServiceImpl.class.getName());
    private int THREAD_COUNT;

    @Override
    public void runThreads() throws IOException {
        setProps();
        logger.info(String.valueOf("Всего потоков: " + THREAD_COUNT));

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new TaskIpr(i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        logger.info("Все потоки завершены!");
    }


    void setProps() throws IOException {
        PropertyValues propertyValues = new PropertyValues();
        Optional<Properties> confValues = propertyValues.getPropValues();
        confValues.ifPresent(propValues -> THREAD_COUNT = Integer.parseInt(propValues.getProperty("thread-count")));
    }
}
