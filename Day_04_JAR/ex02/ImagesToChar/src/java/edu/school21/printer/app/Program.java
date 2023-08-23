package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.JArgs;
import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {
    public static void main ( String[] args ) {
        try {
            JArgs jArgs = new JArgs();
            JCommander.newBuilder().addObject(jArgs).build().parse(args);
            Logic logic = new Logic(jArgs);
            logic.convertImage();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
