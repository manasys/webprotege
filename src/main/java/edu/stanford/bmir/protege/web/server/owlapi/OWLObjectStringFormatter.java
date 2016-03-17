package edu.stanford.bmir.protege.web.server.owlapi;

import com.google.inject.Inject;
import edu.stanford.bmir.protege.web.server.render.ManchesterSyntaxObjectRenderer;
import org.semanticweb.owlapi.io.OWLObjectRenderer;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.util.IRIShortFormProvider;
import org.semanticweb.owlapi.util.ShortFormProvider;
import org.semanticweb.owlapi.util.SimpleRenderer;
import uk.ac.manchester.cs.owl.owlapi.mansyntaxrenderer.ManchesterOWLSyntaxOWLObjectRendererImpl;

import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 16/03/16
 */
public class OWLObjectStringFormatter {

    private final ShortFormProvider shortFormProvider;

    private final IRIShortFormProvider iriShortFormProvider;

    private final OWLObjectRenderer render;

    @Inject
    public OWLObjectStringFormatter(ShortFormProvider shortFormProvider, IRIShortFormProvider iriShortFormProvider) {
        this.shortFormProvider = shortFormProvider;
        this.iriShortFormProvider = iriShortFormProvider;
        render = new ManchesterOWLSyntaxOWLObjectRendererImpl();
        render.setShortFormProvider(shortFormProvider);
    }

    public Optional<String> format(String format, OWLObject... objects) {
        return Optional.of(formatString(format, objects));
    }

    public String formatString(String format, OWLObject... objects) {
        String [] formattedObjects = new String[objects.length];
        for(int i = 0; i < objects.length; i++) {
            formattedObjects[i] = renderObject(objects[i]);
        }
        return String.format(format, formattedObjects);
    }

    private String renderObject(OWLObject object) {
        if(object instanceof OWLEntity) {
            return shortFormProvider.getShortForm((OWLEntity) object);
        }
        else if(object instanceof IRI) {
            return iriShortFormProvider.getShortForm((IRI) object);
        }
        else {
            return render.render(object);
        }
    }

}
