package java21;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a date range.
 */
public record DateRange(LocalDate from, LocalDate to) {

    public DateRange {
        Objects.requireNonNull(from, "'from' date is required");
        Objects.requireNonNull(to, "'to' date is required");

        if (from.isAfter(to)) {
            throw new IllegalArgumentException(
                    "'from' date must be earlier than 'to' date"
            );
        }
    }
}