package com.example.demo.Services;

import com.example.demo.Services.Purchase;
import com.example.demo.Services.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
