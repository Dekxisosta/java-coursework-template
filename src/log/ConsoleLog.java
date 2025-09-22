package log;

import config.AppConfig;
/* ========================================
 *        CONSOLE LOG ENUM
 ==========================================*/
/**
 * Enum representing different console log tags with optional ANSI styling.
 * <p>
 * Each tag can generate a label string suitable for console output.
 * If ANSI is supported, the label is styled with bold, reverse, and a color.
 * Otherwise, it falls back to a plain bracketed label.
 * </p>
 */
public enum ConsoleLog {
    /** Debug-level messages, bright cyan in ANSI terminals. */
    DEBUG("\u001B[96m"),

    /** Error-level messages, bright red in ANSI terminals. */
    ERROR("\u001B[91m"),

    /** System-level messages, bright yellow in ANSI terminals. */
    SYSTEM("\u001B[93m"),

    /** Informational messages, bright green in ANSI terminals. */
    INFO("\u001B[92m");

    /** Whether ANSI escape codes are supported (currently always true). */
    private final boolean IS_ANSI_SUPPORTED = AppConfig.isANSISupported();

    /** ANSI escape code to reset all styles. */
    private final String RESET = "\u001B[0m";

    /** ANSI escape code for bold text. */
    private final String BOLD = "\u001B[1m";

    /** ANSI escape code for reverse/inverse colors. */
    private final String REVERSE = "\u001B[7m";

    /** The primary ANSI color code for this tag. */
    private final String ANSI;

    /**
     * Constructs a ConsoleLog with the given ANSI color code.
     *
     * @param ANSI the ANSI color code associated with this log tag
     */
    ConsoleLog(String ANSI) {
        this.ANSI = ANSI;
    }

    /**
     * Returns the formatted label for this log tag.
     * <p>
     * If ANSI styling is enabled, the label is styled with bold, reverse, and color.
     * Otherwise, it returns a plain bracketed label.
     * </p>
     *
     * @return the styled or plain console label for this tag
     */
    public String label() {
        if (IS_ANSI_SUPPORTED)
            return BOLD + REVERSE + this.ANSI + " " + this.name() + " " + RESET;
        else
            return "[" + this.name() + "]";
    }
}
