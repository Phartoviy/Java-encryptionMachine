package Machine;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemChangerListener implements ItemListener {

    public ItemChangerListener() {
    }

    @Override
    public void itemStateChanged(ItemEvent event)
    {
        if (event.getStateChange() == ItemEvent.SELECTED)
        {
            Object item = event.getItem();
            //System.out.println(item);
        }

    }

}