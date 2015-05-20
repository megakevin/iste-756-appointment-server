package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import data.LookupRepository;
import viewmodel.LookupModel;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("lookups")
public class LookupService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LookupService
     */
    public LookupService() {
    }

    /**
     * Retrieves representation of an instance of service.LookupService
     * @return Map
     */
    @GET
    @Produces("application/json")
    public LookupModel get() {
        LookupModel lookups = LookupRepository.getInstance().getLookup();
        return lookups;
    }
}
