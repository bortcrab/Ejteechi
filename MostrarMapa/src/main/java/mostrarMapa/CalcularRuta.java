package mostrarMapa;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import com.graphhopper.util.Translation;
import dtos.DatosRutaDTO;
import java.util.List;
import java.util.Locale;

public class CalcularRuta {

    private final GraphHopper hopper;
    
    public CalcularRuta() {
        this.hopper = crearGraphHopper("osm/sonora.pbf");
    }

    private GraphHopper crearGraphHopper(String ghLoc) {
        GraphHopper graphHopper = new GraphHopper();
        graphHopper.setOSMFile(ghLoc);
        // specify where to store graphhopper files
        graphHopper.setGraphHopperLocation("target/routing-graph-cache");

        // see docs/core/profiles.md to learn more about profiles
        graphHopper.setProfiles(new Profile("car").setVehicle("car").setWeighting("custom").setTurnCosts(false));

        // this enables speed mode for the profile we called car
        graphHopper.getCHPreparationHandler().setCHProfiles(new CHProfile("car"));

        // now this can take minutes if it imports or a few seconds for loading of course this is dependent on the area you import
        graphHopper.importOrLoad();
        return graphHopper;
    }

    public List<DatosRutaDTO> calcularRuta(List<DatosRutaDTO> datosRuta, double inicioLat, double inicioLon, double finLat, double finLon) {
        // simple configuration of the request object
        GHRequest req = new GHRequest(inicioLat, inicioLon, finLat, finLon).
                // note that we have to specify which profile we are using even when there is only one like here
                setProfile("car").
                // define the language for the turn instructions
                setLocale(Locale.US);
        GHResponse rsp = hopper.route(req);

        // handle errors
        if (rsp.hasErrors()) {
            throw new RuntimeException(rsp.getErrors().toString());
        }

        // use the best path, see the GHResponse class for more possibilities.
        ResponsePath path = rsp.getBest();

        Translation tr = hopper.getTranslationMap().getWithFallBack(Locale.ENGLISH);
        InstructionList il = path.getInstructions();
        // iterate over all turn instructions 
        for (Instruction instruction : il) {
            // System.out.println("distance " + instruction.getDistance() + " for instruction: " + instruction.getTurnDescription(tr));
            datosRuta.add(new DatosRutaDTO(instruction.getDistance(), instruction.getTurnDescription(tr), instruction.getPoints()));
        }
        return datosRuta;
    }
}
