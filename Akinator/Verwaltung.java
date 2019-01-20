import java.util.*;

public class Verwaltung
{
    
    Queue <String> answers = new Queue <String>();
    Queue <String> answerscopy = new Queue <String>();
    boolean stop = false;
    
    


    public Verwaltung()
    {
        BinaryTree <String> aki = new BinaryTree<String>();
        main(aki);
    }
    
    public void main(BinaryTree aki)
    {
        BinaryTree <String> first = new BinaryTree<String>();
        aki.setContent("Ist es Landtier?");
        first.setContent("Hund");
        aki.setLeftTree(first);
        oberflaeche(aki);
    }
    
   
    private void oberflaeche(BinaryTree aki)
    {
      Scanner s =new Scanner(System.in);
      BinaryTree<String> current= aki;
      BinaryTree<String> temp= new BinaryTree<String>();
       while (stop == false)
      {
            System.out.println(current.getContent());
            String antwort = s.next();
            answers.enqueue(antwort);
            
            if (antwort.equalsIgnoreCase("Ja") || antwort.equalsIgnoreCase("Yes"))
            {
                if (current.getLeftTree().isEmpty())
                {
                    System.out.println("Super ich habe das Tier erraten :-)");
                    System.out.println("----------------------------------");
                    System.out.println("Möchtest du von mich erneut benutzen?");
                    antwort = s.next();
                    if (antwort.equalsIgnoreCase("Ja"))
                    {
                        oberflaeche(aki);
                    }
                    else if (antwort.equalsIgnoreCase("Nein"))
                    {
                        stop = true;
                    }
                    
                    
                    
                }
                else 
                {
                   current=current.getLeftTree(); 
                }
            }
      
            if (antwort.equalsIgnoreCase("Nein") || antwort.equalsIgnoreCase("No"))
            {
                if (current.getRightTree().isEmpty())
                {
                    System.out.println("Du hast mich ausgetrickst, möchtest du ein neues Tier eingeben?");
                    antwort = s.next();
                    if (antwort.equalsIgnoreCase("Nein") || antwort.equalsIgnoreCase("No"))
                    {
                        System.out.println("Das Programm wird beendet.");
                        stop=true;
                    }
                    else if (antwort.equalsIgnoreCase("Ja") || antwort.equalsIgnoreCase("Yes"))
                    {
                        hinzufuegen(current , aki);
                        current = aki;
                    }
                }
                else
                {
                    current=current.getRightTree();
                }
            }  
        }
    }
    
    private BinaryTree hinzufuegen(BinaryTree<String> current, BinaryTree aki)
    {
           BinaryTree<String> temp = new BinaryTree<String>();
           Scanner s =new Scanner(System.in); 
           
           temp.setRightTree(current);
           
           System.out.println("Gib ein Tier an:");
           String eingabe=s.nextLine();
           eingabe=s.nextLine();
           temp.getLeftTree().setContent(eingabe);
           
           
           System.out.println("Gib eine Unterscheidungsfrage an:");
           eingabe=s.nextLine();
           eingabe=s.nextLine();
           temp.setContent(eingabe);
           answerscopy=answers;
           tausche (temp, aki);         
           
           return aki;
      }
        
    
    
    private BinaryTree tausche(BinaryTree<String> temp, BinaryTree<String> aki)
    {
        String actual = answerscopy.front();
        
        if (answerscopy.isEmpty())
        {
            aki = temp;
        }
        else
        {}
        if (actual.equalsIgnoreCase("Ja") || actual.equalsIgnoreCase("Yes"))
        {
            answerscopy.dequeue();
            aki.setLeftTree(tausche(temp, aki.getLeftTree()));
        }
        else if (actual.equalsIgnoreCase("Nein") || actual.equalsIgnoreCase("No"))
        {
            answerscopy.dequeue();
            aki.setRightTree(tausche(temp, aki.getRightTree()));
        }
        return aki;
    }
}
