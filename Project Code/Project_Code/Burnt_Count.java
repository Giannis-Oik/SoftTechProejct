import java.util.Scanner;
import java.util.ArrayList;

public class Burnt_Count
{
    private int total_calories;
    
    public Burnt_Count()
    {
        total_calories = 0;
    }
    
    static void Count_Start(ArrayList<Exercise> ExerciseList)
    {
        Burnt_Count count = new Burnt_Count();
        
        System.out.println("Burnt calories counter has initiated. Below you can see the list of different exercises to choose from.");
        
        ShowExerciseList(ExerciseList);
        
        int proceed = 0, found = 0;
        
        while(proceed == 0)
        {
            System.out.println("Please select one exercise to add its calories burnt per 60 minutes to the total count(By its name only).");
        
            Scanner input = new Scanner(System.in);
        
            String item = input.nextLine();
            
            SearchExercise(ExerciseList, count, item, found);
            
            if(found == 1)
            {
                System.out.println("Your selection was found and its calories were added to the total.");
            }else{System.out.println("Your selection was not found.");}
            
            System.out.println("Do you wish to select another item or proceed and see the total calories burnt?(Answer with y to select another or n to proceed)");
            
            item = input.nextLine();
            
            if(item != "n" && item != "N" && item != "NO" && item != "no") 
            {
                proceed = 1;
                System.out.println("You selected to proceed.");
                System.out.println("The total burnt calories of the selected exercises is: " + count.total_calories);
            }else{System.out.println("You will now be prompted to select another item.");}
        }
        
        return;
    }
    
    static void ShowExerciseList(ArrayList<Exercise> ExerciseList)
    {
        for(int i = 0; i < ExerciseList.size(); i++)
        {
            System.out.println(ExerciseList.get(i));
        }
        
        return;
    }
    
    static void SearchExercise(ArrayList<Exercise> ExerciseList,Burnt_Count count, String item, int found)
    {
        Exercise e;
        
        for(int i = 0; i < ExerciseList.size(); i++)
        {
                e = ExerciseList.get(i);
                
                if(e.getExerName() == item)
                {
                    found = 1;
                    count.total_calories += e.getCalBurnt();
                    break;
                }
        }
        
        return;
    }
    
    static void ShowTotal(Burnt_Count count)
    {
        System.out.println("The total burnt calories of the selected exercises is: " + count.total_calories);
        
        return;
    }
}