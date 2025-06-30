package org.example.algorithm;

import org.example.entity.couriers.Courier;
import org.example.entity.order.Order;
import org.example.entity.utils.Point;
import org.example.utils.Utils;

import java.util.*;
import java.util.stream.Collectors;
public class RoutePlanner {
    public Map<Courier, Schedule> plan(List<Courier> couriers, List<Order> orders) {
        Map<Courier, State> states = couriers.stream()
                .collect(Collectors.toMap(c -> c, State::new));
        List<Order> remaining = new ArrayList<>(orders);
        remaining.sort(Comparator.comparing(o -> o.getTime().getStart()));
        while (!remaining.isEmpty()) {
            double bestScore = Double.NEGATIVE_INFINITY;
            Courier bestC = null;
            Order   bestO = null;
            Purpose bestP = null;

            for (Courier c : couriers) {
                State s = states.get(c);
                for (Order o : remaining) {
                    Purpose p = Purpose.createIfFeasible(c, s, o);
                    if (p == null) continue;
                    double score = p.getIncome() / p.getTotalMinutes();
                    if (score > bestScore) {
                        bestScore = score;
                        bestC = c;
                        bestO = o;
                        bestP = p;
                    }
                }
            }
            if (bestP == null) break;
            states.get(bestC).applyPurpose(bestP);
            remaining.remove(bestO);
        }

        Map<Courier, Schedule> result = new HashMap<>();
        for (Courier c : couriers) {
            State s = states.get(c);
            List<Purpose> route = s.getRoute();
            List<Purpose> optimized = twoOptOptimize(route, c);
            result.put(c, new Schedule(optimized));
        }
        return result;
    }

    private List<Purpose> twoOptOptimize(List<Purpose> route, Courier courier) {
        int n = route.size();
        if (n < 3) return new ArrayList<>(route);

        List<Purpose> best = new ArrayList<>(route);
        boolean improved = true;

        while (improved) {
            improved = false;
            double bestDist = routeDistance(best, courier);
            for (int i = 0; i < n - 1 && !improved; i++) {
                for (int j = i + 2; j < n; j++) {
                    List<Purpose> cand = twoOptSwap(best, i, j);
                    double d = routeDistance(cand, courier);
                    if (d + 1e-6 < bestDist) {
                        best = cand;
                        bestDist = d;
                        improved = true;
                        break;
                    }
                }
            }
        }
        return best;
    }

    private List<Purpose> twoOptSwap(List<Purpose> route, int i, int j) {
        List<Purpose> result = new ArrayList<>();
        result.addAll(route.subList(0, i + 1));
        List<Purpose> seg = new ArrayList<>(route.subList(i + 1, j + 1));
        Collections.reverse(seg);
        result.addAll(seg);
        result.addAll(route.subList(j + 1, route.size()));
        return result;
    }

    private double routeDistance(List<Purpose> route, Courier courier) {
        double sum = 0;
        Point cur = courier.getLocation();
        for (Purpose p : route) {
            sum += Utils.getDistance(cur, p.getStartPoint());
            sum += Utils.getDistance(p.getStartPoint(), p.getEndPoint());
            cur = p.getEndPoint();
        }
        return sum;
    }
}