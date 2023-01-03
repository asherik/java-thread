package ru.org;

import ru.org.impl.IprServiceImpl;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

public class Threads {


    public static void main(String[] args) throws IOException {
        IprService iprService = new IprServiceImpl();
        iprService.runThreads();
    }

}
