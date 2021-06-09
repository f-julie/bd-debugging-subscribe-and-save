package com.amazon.ata.debugging.subscribeandsave.test.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Restores subscriptions to the original state between/after tests.
 */
public class SubscriptionRestorer {
    /**
     * Restores the subscriptions data to the same state before/after every test.
     */
    public static void restoreSubscriptions() {
        String subscriptionsFile = "subscriptions.csv";
        String subscriptionsRestoreFile = subscriptionsFile + ".restore";
        Path dataDir = Paths.get(System.getProperty("user.dir").toString(),
                                 "resources/");
        Path source = Paths.get(dataDir.toString(), subscriptionsRestoreFile);
        Path dest = Paths.get(dataDir.toString(), subscriptionsFile);

        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(
                String.format("Error restoring subscriptions data file '%s' from original '%s': %s",
                              subscriptionsFile,
                              subscriptionsRestoreFile,
                              e)
            );
        }
    }
}
