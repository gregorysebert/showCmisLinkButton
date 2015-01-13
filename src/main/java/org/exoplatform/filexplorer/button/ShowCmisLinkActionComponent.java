package org.exoplatform.filexplorer.button;

import org.exoplatform.ecm.webui.component.explorer.UIJCRExplorer;
import org.exoplatform.ecm.webui.component.explorer.control.listener.UIActionBarActionListener;
import org.exoplatform.web.application.ApplicationMessage;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIComponent;
import org.exoplatform.webui.event.Event;

import javax.jcr.Node;


@ComponentConfig(events = { @EventConfig(listeners = ShowCmisLinkActionComponent.ShowCmisLinkActionListener.class) })


public class ShowCmisLinkActionComponent extends UIComponent {


    public static class ShowCmisLinkActionListener extends UIActionBarActionListener<ShowCmisLinkActionComponent> {

        @Override

        protected void processEvent(Event<ShowCmisLinkActionComponent> event) throws Exception {

            UIJCRExplorer uiJCRExplorer = event.getSource().getAncestorOfType(UIJCRExplorer.class);

            Node node = uiJCRExplorer.getCurrentNode();


            // add business logic

            event.getRequestContext()

                    .getUIApplication() //recupere le composant applicatif (object file explorer. addMessage ouvre une popup

                    .addMessage(new ApplicationMessage("Cmis id:" + node.getProperty("ecd:id") + "eXo name : "+ node.getProperty("exo:name"), null, ApplicationMessage.INFO));

        }

    }

}
