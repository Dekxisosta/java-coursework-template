package config;

/**
 * Application-level configuration class.
 * <p>
 * Provides central access to global constants and settings
 * used across the program, such as program name and feature flags.
 * </p>
 */
public class AppConfig {

    /** The display name of the program. */
    private static final String PROGRAM_NAME = "Dekxi's Java Coursework Template";

    /** Flag indicating whether ANSI escape codes are supported in this environment. */
    private static final boolean IS_ANSI_SUPPORTED = true;

    /**
     * Returns the configured program name.
     *
     * @return the program name as a string
     */
    public static String getProgramName() {
        return PROGRAM_NAME;
    }

    /**
     * Checks whether ANSI escape codes are supported.
     *
     * @return {@code true} if ANSI codes are enabled; {@code false} otherwise
     */
    public static boolean isANSISupported() {
        return IS_ANSI_SUPPORTED;
    }
}
