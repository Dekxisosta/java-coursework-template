package util;

import config.AppConfig;
/* ========================================
 *        CONSOLE LOG ENUM
 ==========================================*/
/**
 *
 * Logger class for distinction of
 * DEPENDENCIES:
 * {@link Ansi} for colored logs
 * </p>
 */
public enum Logger {
    DEBUG(Ansi.BRIGHT_CYAN.toString()),
    ERROR(Ansi.BRIGHT_RED.toString()),
    SYSTEM(Ansi.BRIGHT_YELLOW.toString()),
    INFO(Ansi.BRIGHT_GREEN.toString());

    private AppConfig config = AppConfig.getInstance();
    private final boolean IS_ANSI_SUPPORTED = config.isANSISupported();

    /** The primary ANSI color code for this tag. */
    private final String code;

    /**
     * Constructs a Logger with the given ANSI color code.
     *
     * @param code the ANSI color code associated with this log tag
     */
    Logger(String code) {
        this.code = code;
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
            return Ansi.BOLD.toString() + Ansi.REVERSE.toString() + this.code + " " + this.name() + " " + Ansi.RESET.toString();
        else
            return "[" + this.name() + "]";
    }
}
