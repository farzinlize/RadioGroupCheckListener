import android.widget.CompoundButton;

/**
 * Created by Farzin on 2/13/2018.
 */
public class RadioGroupCheckListener implements CompoundButton.OnCheckedChangeListener {

    private CompoundButton[] allies;

    /**
     * public generator - indicate allies
     * @param allies all other buttons in the same RadioGroup
     */
    public RadioGroupCheckListener(CompoundButton... allies){
        this.allies = allies;
    }

    /**
     * listener for a button to turn other allies unchecked when it turn checked
     * @param buttonView change check occur with this button
     * @param isChecked result of changing
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            for (CompoundButton aly : allies) {
                aly.setChecked(false);
            }
        }
    }

    /**
     * inner private function to remove one element from Buttons array
     * @param buttons all the buttons in RadioGroup
     * @param me the index that we want to remove from array
     * @return an array of CompoundButtons except the index of me
     */
    private static CompoundButton[] exceptMe(CompoundButton[] buttons, int me){
        CompoundButton[] result = new CompoundButton[buttons.length-1];
        for(int i=0,j=0;i<buttons.length;i++){
            if(i==me){
                continue;
            }
            result[j]=buttons[i];
            j++;
        }
        return result;
    }

    /**
     * static function to create a RadioGroup
     * if a button turn to checked state all other buttons is group turn unchecked
     * @param buttons the buttons that we want to act like RadioGroup
     */
    public static void makeGroup(CompoundButton... buttons){
        for(int i=0;i<buttons.length;i++){
            buttons[i].setOnCheckedChangeListener(new RadioGroupCheckListener(exceptMe(buttons, i)));
        }
    }

    /**
     * static function to create a RadioGroup with buttons ids
     * if a button turn to checked state all other buttons is group turn unchecked
     * @param activity activity that contain this group too find views by their ids
     * @param buttonIDs the buttons ids that we want to act like RadioGroup
     */
    public static void makeGroup(Activity activity, int... buttonIDs){
        CompoundButton[] buttons = new CompoundButton[buttonIDs.length];
        for(int i=0;i<buttonIDs.length;i++)
            buttons[i] = (CompoundButton) activity.findViewById(buttonIDs[i]);
        makeGroup(buttons);
    }

}
