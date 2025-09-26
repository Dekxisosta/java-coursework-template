package config;

import util.*;

/**
 * Singleton Application-level configuration class.
 */
public class AppConfig {
    private static String PROGRAM_NAME;
    private static String AUTHOR_NAME;
    private static String AUTHOR_BANNER;
    private static String DATE_CREATED;
    private static boolean IS_ANSI_SUPPORTED;
    private static String HEADER_COLOR;

    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
        PROGRAM_NAME = "Java Coursework Linked List Template";
        AUTHOR_NAME = "Dekxi";
        IS_ANSI_SUPPORTED = true;
        AUTHOR_BANNER = """
                 _____         __           __
                |     \\.-----.|  |--.--.--.|__|   || UI DESIGNER          |
                |  --  |  -__||    <|_   _||  |   || PROGRAMMER           |
                |_____/|_____||__|__|__.__||__|   || VOCALOID ENTHUSIAST  |
                """;
        DATE_CREATED = "2025 / 09 / 24";
        HEADER_COLOR = "" + Ansi.WHITE;
    }

    /** @return instance of AppConfig */
    public static AppConfig getInstance() {
        return INSTANCE;
    }

    /** @return program name */
    public String getProgramName() {
        return PROGRAM_NAME;
    }

    /** @return author name */
    public String getAuthorName() {
        return AUTHOR_NAME;
    }

    /** @return true if ANSI codes are supported */
    public boolean isANSISupported() {
        return IS_ANSI_SUPPORTED;
    }

    /** @return author banner */
    public String getAuthorBanner() {
        return AUTHOR_BANNER;
    }

    /** @return date created */
    public String getDateCreated() {
        return DATE_CREATED;
    }

    /** @return header color */
    public String getHeaderColor() {
        return HEADER_COLOR;
    }
}
