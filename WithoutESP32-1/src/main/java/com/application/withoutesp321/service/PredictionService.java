package com.application.withoutesp321.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PredictionService {

    // Simulated model prediction function (for demo purposes)
    public Map<String, Object> predictForHours(int hours) {
        double[] predictions = new double[hours];
        double baseTemp = 25.0;

        // Generate predictions (replace with actual model logic in a real scenario)
        for (int i = 0; i < hours; i++) {
            predictions[i] = baseTemp + Math.random() * 5; // Simulate variation
        }

        // Simulate actual data (normally this would come from the database or real sensors)
        double[] actuals = new double[hours];
        for (int i = 0; i < hours; i++) {
            actuals[i] = baseTemp + Math.random() * 5; // Simulate actual data
        }

        // Calculate metrics
        double mse = calculateMSE(predictions, actuals);
        double r2 = calculateR2(predictions, actuals);

        // Prepare detailed predictions with timestamps
        List<Map<String, Object>> predictionDetails = new ArrayList<>();
        LocalDateTime currentTime = LocalDateTime.now();

        for (int i = 0; i < hours; i++) {
            Map<String, Object> predictionMap = new HashMap<>();
            predictionMap.put("hour", i + 1); // Human-readable hour (1, 2, 3, etc.)
            predictionMap.put("predicted_temperature", predictions[i]);
            predictionMap.put("actual_temperature", actuals[i]);
            predictionMap.put("timestamp", currentTime.plusHours(i).toString()); // Timestamp for each prediction

            predictionDetails.add(predictionMap);
        }

        // Structure the full response with predictions and metrics
        Map<String, Object> response = new HashMap<>();
        response.put("prediction_summary", "Temperature forecast for the next " + hours + " hour(s)");
        response.put("metrics", Map.of(
                "mean_squared_error", mse,
                "r_squared", r2
        ));
        response.put("predictions", predictionDetails);

        return response;
    }

    // Calculate Mean Squared Error (MSE)
    private double calculateMSE(double[] predictions, double[] actuals) {
        double mse = 0.0;
        for (int i = 0; i < predictions.length; i++) {
            mse += Math.pow(predictions[i] - actuals[i], 2);
        }
        return mse / predictions.length;
    }

    // Calculate R-squared value (R²)
    private double calculateR2(double[] predictions, double[] actuals) {
        double mean = 0.0;
        for (double value : actuals) {
            mean += value;
        }
        mean /= actuals.length;

        double ssTotal = 0.0, ssResidual = 0.0;
        for (int i = 0; i < actuals.length; i++) {
            ssTotal += Math.pow(actuals[i] - mean, 2);
            ssResidual += Math.pow(actuals[i] - predictions[i], 2);
        }

        return 1 - (ssResidual / ssTotal);
    }
}
