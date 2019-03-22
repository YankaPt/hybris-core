package customers.events;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import java.io.Serializable;

public class MyAfterCreationEvent extends AbstractEvent {
    Object source;

    public MyAfterCreationEvent(Serializable source) {
        super(source);
        this.source = source;
    }
}
