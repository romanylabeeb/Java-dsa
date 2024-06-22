package dsa.mustafaSaad.designpatteren.builder;
// 1. Product Class:

/**
 * Scenario: Creating a Configuration Object
 * Imagine you need to create a configuration object for connecting to a database.
 * The configuration might include parameters like hostname, port, username, password, and other settings.
 * Using a constructor to handle all these parameters can lead to confusion and errors.
 */
public class DatabaseConfig {
    private String hostname;
    private int port;
    private String username;
    private String password;
    private boolean useSSL;
    private int timeout;

    private DatabaseConfig(DatabaseConfigBuilder builder) {
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.useSSL = builder.useSSL;
        this.timeout = builder.timeout;
    }

    public static class DatabaseConfigBuilder {
        private String hostname;
        private int port;
        private String username;
        private String password;
        private boolean useSSL;
        private int timeout;

        public DatabaseConfigBuilder setHostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public DatabaseConfigBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public DatabaseConfigBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public DatabaseConfigBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public DatabaseConfigBuilder setUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        public DatabaseConfigBuilder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }

    @Override
    public String toString() {
        return "DatabaseConfig [hostname=" + hostname + ", port=" + port + ", username=" + username + ", password=" + password
                + ", useSSL=" + useSSL + ", timeout=" + timeout + "]";
    }

    // Client code
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig.DatabaseConfigBuilder()
                .setHostname("localhost")
                .setPort(5432)
                .setUsername("admin")
                .setPassword("secret")
                .setUseSSL(true)
                .setTimeout(30)
                .build();
        System.out.println(config);

    }
}

// the main method

// the main method






