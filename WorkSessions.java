/* There are n tasks assigned to you. The task times are represented as an integer array tasks of length n, where 
the ith task takes tasks[i] hours to finish. A work session is when you work for at most sessionTime consecutive 
hours and then take a break. You should finish the given tasks in a way that satisfies the following conditions:
? If you start a task in a work session, you must complete it in the same work session.
? You can start a new task immediately after finishing the previous one.
You may complete the tasks in any order. Given tasks and sessionTime, return the minimum number of work sessions 
needed to finish all the tasks following the conditions above. The tests are generated such that sessionTime is 
greater than or equal to the maximum element in tasks[i].
* Eg 1 :  tasks = [1,2,3]         SessionTime = 3                 Output = 2
* Eg 2 :  tasks = [1,3,1,1,3]     SessionTime = 8                 Output = 2
* Eg 3 :  tasks = [1,2,3,4,5]     SessionTime = 15                Output = 1
*/
import java.util.*;
public class WorkSessions
{
      public int MinimumSessions(int task[], int SessionTime)
      {
            // Reverse Order Priority Queue -> Larger Element placed first...
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> b - a);  //* Max Heap -> O(N)
            for(int i = 0; i < task.length; i++)     //! Entering Data -> O(N)
            {     // Entering data in Queue...
                  queue.add(task[i]);
            }
            int session = 0, sum = 0;      // Declaring variables...
            while(!queue.isEmpty())     //! Comparison -> O(N)
            {
                  sum = sum + queue.peek();    // Getting sum...
                  if(sum <= SessionTime)
                        queue.remove(queue.peek());    // If the sum is less than session time...
                  else
                  {
                        sum = 0;     // Setting sum to zero...
                        session++;
                  }
            }
            return session + 1;    // Returning the number of Sessions...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter the number of tasks : ");
            x = sc.nextInt();
            int nums[] = new int[x];
            for(int i = 0; i < nums.length; i++)
            {
                  System.out.print("Enter task time : ");
                  nums[i] = sc.nextInt();
            }
            System.out.print("Enter the Session time : ");
            x = sc.nextInt();
            WorkSessions worksession = new WorkSessions();       // Object creation...
            System.out.println("The Minimum Work Sessions required : "+worksession.MinimumSessions(nums, x));
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS :-
 * ? Create a reverse Priority Queue (Max Heap) to get the elements in an ascending order...
 * ? We check how many tasks can be completed within the given session time...
 */