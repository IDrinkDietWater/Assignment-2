import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

public class PollingProgram {


    private static final int TOPIC_ARRAY_SIZE = 6;
    private static final int RESULT_ARRAY_SIZE = 12;
    private static final int AVG_ROW_INDEX = 11;

    public static void main(String[] args) {

        // Stores if participants are done rating the topics
        boolean isFinished = false;
        Scanner scnr = new Scanner(System.in);
        int numberOfParticipants = 0;
        // Declare One Dimensional Array of Topics
        StringBuilder[] topics = new StringBuilder[TOPIC_ARRAY_SIZE];

        // Topics array
		topics[0] = new StringBuilder("The addition of Latveria to the UN       ");        
        topics[1] = new StringBuilder("Finding out Obama's last name            ");
        topics[2] = new StringBuilder("The release of season 2 of The Boys      ");
        topics[3] = new StringBuilder("The Applejack/Rainbow Dash rivalry in MLP");
        topics[4] = new StringBuilder("politics.                                ");

        // Declare Two Dimensional Array of Results
        StringBuilder[][] responses = new StringBuilder[TOPIC_ARRAY_SIZE][RESULT_ARRAY_SIZE];

        for (int i = 0; i < RESULT_ARRAY_SIZE; i++) {

            for (int j = 0; j < TOPIC_ARRAY_SIZE; j++) {
                if (i == 0 && j == 0) {
                    responses[j][i] = new StringBuilder();
                }
                if (i == 0) {
                    responses[1][i] = topics[0];
                    responses[2][i] = topics[1];
                    responses[3][i] = topics[2];
                    responses[4][i] = topics[3];
                    responses[5][i] = topics[4];
                    continue;
                }
                if (j == 0) {
                    responses[j][i] = new StringBuilder(String.valueOf(i));
                    if (i == AVG_ROW_INDEX) {
                        responses[j][i] =  new StringBuilder("AVG");
                    }
                } else {
                    responses[j][i] = new StringBuilder("0");
                }
            }
        }

        // Add an average ratings to the Two Dimensional array
        System.out.println("You will be presented with five topics,"
                + " please rate each topic from 1 to 10 (inclusive)\n");

        while (!isFinished) {
            for (int i = 1; i < TOPIC_ARRAY_SIZE; i++) {
                ShowQuestion(i, responses);
                int responseRating = GetNumericResponse();
                int responseValue = Integer.parseInt(responses[i][responseRating].toString()) + 1;
                responses[i][responseRating] = new StringBuilder(Integer.toString(responseValue));
            }
            numberOfParticipants += 1;
            System.out.println("Response Recorded! " +
                    "Press \"q\" to quit and view results or press any other key to add another result set.");
            isFinished = scnr.next().equalsIgnoreCase("q");
        }
        CalculateAverage(numberOfParticipants, responses);
        PrintResponses(responses);

        // Show the highest rated issue and its point total
        HashMap<Integer, Integer> ratings = CalculateRatings(responses);

        Integer maximumValueRowIndex = Collections.max(ratings.entrySet(), comparingInt(Map.Entry::getValue)).getKey();
        System.out.printf("\nThe issue with highest point total is \"%s\" with a total of %d points\n", responses[maximumValueRowIndex][0], ratings.get(maximumValueRowIndex));

        // Show the lowest rated issue and its point total
        Integer minimumValueRowIndex = Collections.min(ratings.entrySet(), comparingInt(Map.Entry::getValue)).getKey();
        System.out.printf("\nThe issue with lowest point total is \"%s\" with a total of %d points\n", responses[minimumValueRowIndex][0], ratings.get(minimumValueRowIndex));
    }

    private static HashMap CalculateRatings(StringBuilder[][] responses) {
        HashMap<Integer, Integer> indexAndTotalRating = new HashMap<Integer, Integer>();

        for (int index = 1; index < TOPIC_ARRAY_SIZE; index++) {
            Integer totalRating = 0;
            for(int j = 1; j < AVG_ROW_INDEX; j++) {
                totalRating += Integer.parseInt(responses[index][j].toString())*j;
            }
            indexAndTotalRating.put(index, totalRating);
        }
        return indexAndTotalRating;
    }

    private static void CalculateAverage(int numberOfParticipants, StringBuilder[][] responses) {

        for(int i = 1; i < TOPIC_ARRAY_SIZE; i++) {
            Double sum = 0.0;
            Double average = 0.0;
            for(int j = 1; j < AVG_ROW_INDEX; j++) {
                sum += Double.parseDouble(responses[i][j].toString()) * j;
            }
            average = sum / Double.parseDouble(String.valueOf(numberOfParticipants));
            responses[i][AVG_ROW_INDEX] = new StringBuilder(String.format("%3.1f", average));
        }
    }

    private static int GetNumericResponse() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("On a scaled of 1 to 10 how do you feel about this issue?");
        int finalRating = 0;
        while(finalRating == 0)
        {
            String stringResponse = scnr.next();
            if (!stringResponse.isEmpty()) {
                try {
                    int rating = Integer.parseInt(stringResponse);
                    if (rating < 0 || rating > 10) {
                        throw new NumberFormatException();
                    }
                    else if (rating <= 10 && rating >= 1){
                        finalRating = rating;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid integer entered! Please enter a number between 1 and 10 (inclusive)");
                }
            }}
        return finalRating;
    }

    private static void ShowQuestion(int j, StringBuilder[][] responses) {
        System.out.println(responses[j][0]);
    }

    private static void PrintResponses(StringBuilder[][] responses) {
        System.out.println();
        System.out.print("---------------------------- Ratings -->");
        for (int i = 0; i < TOPIC_ARRAY_SIZE; i++) {
            for (int j = 0; j < RESULT_ARRAY_SIZE; j++) {
                if (j == 0) {
                    System.out.printf("%-1s", responses[i][j]);
                } else {
                    System.out.printf("%6s", responses[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("__________________________________________________________________________________________________");
    }
}
