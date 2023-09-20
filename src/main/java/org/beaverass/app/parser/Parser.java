package org.beaverass.app.parser;

import java.io.IOException;
import java.util.Map;

public interface Parser {
    Map<Integer,String> parseFile(String path) throws IOException;
}
