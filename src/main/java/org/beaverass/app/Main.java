package org.beaverass.app;

import org.beaverass.app.exception.UnknownCommandException;
import org.beaverass.app.view.PairGeneratorView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws UnknownCommandException, IOException {

        new PairGeneratorView().run();

    }

}
