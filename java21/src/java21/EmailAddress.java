package java21;

record EmailAddress(String address) {

    public EmailAddress {
        if (!isValidEmailAddress(address)) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    private static boolean isValidEmailAddress(String email) {
        // Implement email validation rules here.
        // Simplified example, real-world validation may be more complex.
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}