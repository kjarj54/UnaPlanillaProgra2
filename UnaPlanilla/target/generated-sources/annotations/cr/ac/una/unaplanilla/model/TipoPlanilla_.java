package cr.ac.una.unaplanilla.model;

import cr.ac.una.unaplanilla.model.Empleado;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-12T19:43:50", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(TipoPlanilla.class)
public class TipoPlanilla_ { 

    public static volatile SingularAttribute<TipoPlanilla, String> descripcion;
    public static volatile SingularAttribute<TipoPlanilla, String> codigo;
    public static volatile SingularAttribute<TipoPlanilla, String> estado;
    public static volatile SingularAttribute<TipoPlanilla, Integer> mesultpla;
    public static volatile ListAttribute<TipoPlanilla, Empleado> empleadoList;
    public static volatile SingularAttribute<TipoPlanilla, Integer> anoultpla;
    public static volatile SingularAttribute<TipoPlanilla, Integer> numultpla;
    public static volatile SingularAttribute<TipoPlanilla, Long> id;
    public static volatile SingularAttribute<TipoPlanilla, Integer> plaxmes;
    public static volatile SingularAttribute<TipoPlanilla, Long> version;

}