package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcolor.Attribute;

@Parameters(separators = "=")
public class JArgs {
        @Parameter(names = "--white", required = true)
        private String white;

        @Parameter(names = "--black", required = true)
        private String black;

        public Attribute getWhite() {
            return getAttribute(white);
        }

        public Attribute getBlack() {
            return getAttribute(black);
        }

    private Attribute getAttribute ( String black ) {
        if ("BLACK".equals(black)) {
            return Attribute.BLACK_BACK();
        } else if ("WHITE".equals(black)) {
            return Attribute.WHITE_BACK();
        } else if ("BLUE".equals(black)) {
            return Attribute.BLUE_BACK();
        } else if ("GREEN".equals(black)) {
            return Attribute.GREEN_BACK();
        } else if ("MAGENTA".equals(black)) {
            return Attribute.MAGENTA_BACK();
        } else if ("RED".equals(black)) {
            return Attribute.RED_BACK();
        } else if ("YELLOW".equals(black)) {
            return Attribute.YELLOW_BACK();
        } else if ("CYAN".equals(black)) {
            return Attribute.CYAN_BACK();
        }
        return Attribute.WHITE_BACK();
    }
}
