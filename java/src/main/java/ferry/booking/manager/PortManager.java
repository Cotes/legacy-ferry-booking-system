package ferry.booking.manager;


import ferry.booking.PortModel;
import ferry.booking.domain.Ferries;
import ferry.booking.domain.Ports;
import ferry.booking.dto.Ferry;
import ferry.booking.dto.Port;

import java.util.ArrayList;
import java.util.List;

public class PortManager {

    private final Ports ports;
    private final Ferries ferries;

    public PortManager(Ports ports, Ferries ferries) {
        this.ports = ports;
        this.ferries = ferries;
    }

    public List<PortModel> PortModels() {
        List<PortModel> allPorts = new ArrayList<>();
        for (Port port : ports.all()) {
            allPorts.add(new PortModel(port));
        }
        for (Ferry ferry : ferries.all()) {
            for (PortModel port : allPorts) {
                if (port.id == ferry.homePortId) {
                    port.addBoat(10, ferry);
                }
            }
        }
        return allPorts;
    }
}
