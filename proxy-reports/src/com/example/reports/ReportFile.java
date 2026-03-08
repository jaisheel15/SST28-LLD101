package com.example.reports;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Concrete class used directly by clients
 * - Expensive load happens every time display() is called
 * - No access control
 *
 * TODO (student):
 * - Convert this into the RealSubject behind a Proxy, or replace with
 * RealReport.
 */
public class ReportFile implements Report {

    private final ReportProxy proxy;

    public ReportFile(String reportId, String title, String classification) {
        this.proxy = new ReportProxy(reportId, title, classification);
    }

    @Override
    public void display(User user) {
        proxy.display(user);
    }
}
