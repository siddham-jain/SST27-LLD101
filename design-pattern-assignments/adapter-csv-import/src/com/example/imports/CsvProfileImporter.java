package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {

    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader);
        this.profileService = Objects.requireNonNull(profileService);
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int importedCount = 0;
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            int rowNumber = i + 1; // For logging purposes

            if (row.length < 3) {
                System.out.println("Skipping row " + rowNumber + ": Invalid number of columns. Expected 3 (id, email, displayName), got " + row.length);
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            if (id.isEmpty()) {
                System.out.println("Skipping row " + rowNumber + ": ID is missing.");
                continue;
            }

            if (email.isEmpty()) {
                System.out.println("Skipping row " + rowNumber + ": Email is missing.");
                continue;
            }

            if (!email.contains("@")) {
                System.out.println("Skipping row " + rowNumber + ": Invalid email format.");
                continue;
            }

            try {
                profileService.createProfile(id, email, displayName);
                importedCount++;
            } catch (Exception e) {
                // This catch block is for unexpected errors from profileService,
                // though the assignment implies validation should happen in the adapter.
                System.out.println("Skipping row " + rowNumber + ": Error creating profile - " + e.getMessage());
            }
        }
        return importedCount;
    }
}
