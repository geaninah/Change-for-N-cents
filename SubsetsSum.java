import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class SubsetsSum
{
    
    static int sum(List<Integer> list)
    {
        int sum = 0;

        for(Integer value : list)
        {
            sum += value;
        }

        return sum;
    }

    static List<Integer> createList(List<Integer> list, int totalSum)
    {
        List<Integer> newList = new ArrayList<>();

        // Create a new list which contains each element from the initial list (totalSum / value) times
        // For example if we have 5 as sum and elements 1 2 3 our list will be 11111223
        
        for(Integer value : list)
        {
            int elements = totalSum / value;

            while(elements > 0)
            {
                newList.add(value);
                elements--;
            }
        }

        return newList;
    }

    static Set<List<Integer>> subsets(List<Integer> list)
    {
        if(list == null)
        {
            return null;
        }
     
        Set<List<Integer>> result = new HashSet<List<Integer>>();
     
        for (int i = 0; i < list.size(); i++) 
        {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
     
            // Get sets that are already in result
            for (List<Integer> a : result) 
            {
                temp.add(new ArrayList<Integer>(a));
            }
     
            // Add current element of the main set to existing sets
            for (List<Integer> a : temp) 
            {
                a.add(list.get(i));
            }
     
            // Add current element only as a set
            List<Integer> single = new ArrayList<Integer>();
            single.add(list.get(i));
            temp.add(single);
     
            result.addAll(temp);
        }
     
        return result;
    }

    static int pairOfCoins(List<Integer> list, int totalSum)
    {
        List<Integer> newList = createList(list, totalSum);

        Set<List<Integer>> sets = subsets(newList);

        int noOfPairs = 0;

        for(List<Integer> set : sets)
        {
            if(sum(set) == totalSum)
            {
                noOfPairs++;
            }
        }

        return noOfPairs;
    }

    public static void main(String args[])
    {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);

        System.out.println(pairOfCoins(list, 20));
        System.out.println(pairOfCoins(list, 10));
        System.out.println(pairOfCoins(list, 1));
    }
}
