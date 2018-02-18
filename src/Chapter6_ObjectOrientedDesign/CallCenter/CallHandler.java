package Chapter6_ObjectOrientedDesign.CallCenter;

import java.util.List;

/**
 * Created by selimkonuk on 18/02/2018.
 */
public class CallHandler {
    // Level by level list of employees.
    private List<List<Employee>> employees;

    // Level by level list of call queues.
    private List<List<Call>> callQueues;

    /*
     * finds and returns first available employee
     * for the call. Remember the importance of
     * the call level.
     */
    public Employee getHandlerEmployee(Call call) {
        // Implementation logic
        return null;
    }

    /*
     * when a caller calls the center, this method
     * will first triggered. After transferred to
     * dispatch the call to an employee.
     */
    public void getCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee employee = getHandlerEmployee(call);
        if (employee != null) {
            call.setHandler(employee);
            employee.assignCall(call);
        } else {
            // inform customer to wait.
            // Then add it to the queue.
        }
    }

    /*
     * If an employee notifies that he or she is
     * available, this function will trigger.
     */
    public void anyAvailableEmployee() {
        /*
         * gets the latest call and checks if it still
         * waits. If so dispatch the call. Else gets
         * other call and so on.
         */
    }

}
