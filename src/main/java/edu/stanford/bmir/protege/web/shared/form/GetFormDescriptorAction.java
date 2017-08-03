package edu.stanford.bmir.protege.web.shared.form;

import edu.stanford.bmir.protege.web.shared.HasProjectId;
import edu.stanford.bmir.protege.web.shared.HasSubject;
import edu.stanford.bmir.protege.web.shared.collection.CollectionElementId;
import edu.stanford.bmir.protege.web.shared.collection.CollectionId;
import edu.stanford.bmir.protege.web.shared.dispatch.Action;
import edu.stanford.bmir.protege.web.shared.dispatch.ProjectAction;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 30/03/16
 */
public class GetFormDescriptorAction implements ProjectAction<GetFormDescriptorResult> {

    private ProjectId projectId;

    private CollectionId collectionId;

    private FormId formId;

    private CollectionElementId elementId;

    private GetFormDescriptorAction() {
    }

    public GetFormDescriptorAction(ProjectId projectId,
                                   CollectionId collectionId,
                                   FormId formId,
                                   CollectionElementId elementId) {
        this.projectId = checkNotNull(projectId);
        this.collectionId = checkNotNull(collectionId);
        this.formId = checkNotNull(formId);
        this.elementId = checkNotNull(elementId);
    }

    @Nonnull
    @Override
    public ProjectId getProjectId() {
        return projectId;
    }

    public FormId getFormId() {
        return formId;
    }

    public CollectionId getCollectionId() {
        return collectionId;
    }

    public CollectionElementId getElementId() {
        return elementId;
    }
}
