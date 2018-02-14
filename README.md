# RadioGroupCheckListener
a better solution instead of `RadioGroup` in android
---
if you use `RadioGroup` in android, you can't put `RadioButtons` anywhere you want except the exact child of your `RadioGroup` with no depth of hierarchy. so if you want to put your `RadioButtons` in a `LinearLayout` or manage it in a grid, buttons don't act like their belongs to the group (they will stay checked if the user check another `RadioButton` in the group)

## How to use `RadioGroupCheckListener`
import the file and simply add this line of code to declare a `RadioGroup`:
```
RadioGroupCheckListener.makeGroup(radioButton1, radioButton2, radioButton3, radioButton4);
```
or use this function using their ids instead of using their objects (`this` is the activity that contains radio buttons)
```
RadioGroupCheckListener.makeGroup(this, R.id.radioButton1_id, R.id.radioButton2_id, R.id.radioButton3_id, R.id.radioButton4_id);
```
