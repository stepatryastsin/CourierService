package org.example.entity.validate;

import org.example.entity.utils.Point;
import org.example.entity.utils.Time;
import org.example.entity.order.OrderType;

public record OrderData(
      int id,
      Point start,
      Point finish,
      Time time,
      double weight,
      OrderType type
) {}
