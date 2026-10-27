package com.mattee37.patterns.structural.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern ===\n");

        System.out.println("Creating image proxies (no loading yet):\n");

        ImageProxy image1 = new ImageProxy("photo1.jpg");
        ImageProxy image2 = new ImageProxy("photo2.jpg");
        ImageProxy image3 = new ImageProxy("photo3.jpg");

        System.out.println("\nDisplaying image1 (loads now):");
        image1.display();

        System.out.println("\nDisplaying image1 again (already loaded):");
        image1.display();

        System.out.println("\nDisplaying image2 (loads now):");
        image2.display();

        System.out.println("\n(image3 was never displayed, so never loaded)");
    }
}
