/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.rdf;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author Jei
 */
public interface Model {

    /**
     * size will return the number of statements in a concrete model,
     * for a virtualized model such as one created by an inference engine,
     * it will return an estimated lower bound for the numberof statements
     * in the model but it is possible for a subsequent listStatements on
     * such a model to discover more statements than size() indicated.
     * @return the number of statements in a concrete model or an estimated
     * lower bound on the number of statements in an virtualized model
     */
    long size();

    /**
    Answer true iff the model contains no explicit statements (ie it's size is zero,
    listStatements() would deliver the empty iterator).
    
    @return true iff the model contains no explicit statements.
     */
    boolean isEmpty();

    /** List all resources which are subjects of statements.
     *
     * <p>Subsequent operations on those resource may modify this model.</p>
    
     * @return an iterator over a set of resources which are subjects of statements
     *         in the model. .remove() is not implemented on this iterator.
     *
     */
//    ResIterator listSubjects();

    /**
    (You probably don't want this method; more likely you want the
    PrefixMapping methods that Model supports.) List the namespaces used
    by predicates and types in the model. This method is really intended
    for use by the RDF/XML writer, which needs to know these
    namespaces to generate correct and vaguely pretty XML.
    <p>
    The namespaces returned are those of (a) every URI used as a property in the
    model and (b) those of every URI that appears as the object of an rdf:type statement.
    <p>
    Note that the notion of "namespace" used here is not that of an XML
    prefix-namespace, but just of the minimal legal left part of a URI
    (see Util.splitNamespace for details). If you want the RDF/XML (or
    N3) namespaces, treat the Model as a PrefixMapping.
    
    @see com.hp.hpl.jena.shared.PrefixMapping
    @return an iterator over every predicate and type namespace
     */
//    NsIterator listNameSpaces();

    /**
    Return a Resource instance with the given URI in this model. <i>This method
    behaves identically to <code>createResource(String)</code></i> and exists as
    legacy: createResource is now capable of, and allowed to, reuse existing objects.
    <p>
    Subsequent operations on the returned object may modify this model.
    @return a resource instance
    @param uri the URI of the resource
     */
    Resource getResource(String uri);

    /**
    Return a Property instance with the given URI in this model. <i>This method
    behaves identically to <code>createProperty(String,String)</code></i> and exists as
    legacy: createProperty is now capable of, and allowed to, reuse existing objects.
    <p>
    Subsequent operations on the returned property may modify this model.
    @return a property linked to this model
    @param nameSpace the RDF namespace of the property
    @param localName the localName of the property in its namespace
     */
    Property getProperty(String nameSpace, String localName);

    /**
    Create a new anonymous resource whose model is this model. This bnode will
    have a new AnonId distinct from any allocated by any other call of this method.
    <p>
    Subsequent operations on the returned resource may modify this model.
    @return a new anonymous resource linked to this model.
     */
    public Resource createResource();

    /**
    Create a blank node resource with a specified identifier. The resulting bnode
    will be equal to any other bnode with the same AnonId (even if they are in
    separate models - be warned). The intended use for this method is to allow
    bnode round-tripping between Jena models and other representations.
    <p>
    This method may return an existing bnode with the correct AnonId and model, or it
    may construct a fresh one, as it sees fit.
    <p>
    Operations on the result may modify this model
    @param id the identifier to use for this blank node
    @return a blank node with that identifier
     */
//    public Resource createResource(AnonId id);

    /**
    Create a new resource associated with this model. If the uri string is null, this creates
    a bnode, as per <code>createResource()</code>. Otherwise it creates a URI node.
    A URI resource is .equals() to any other URI Resource with the same URI (even in
    a different model - be warned).
    <p>
    This method may return an existing Resource with the correct URI and model, or it
    may construct a fresh one, as it sees fit.
    <p>
    Operations on the result Resource may change this model.
    
    @param uri the URI of the resource to be created
    @return a new resource linked to this model.
     */
    public Resource createResource(String uri);

    /**
    Create a property with a given URI composed from a namespace part and a
    localname part by concatenating the strings.
    <p>
    This method may return an existing property with the correct URI and model, or it
    may construct a fresh one, as it sees fit.
    <p>
    Subsequent operations on the returned property may modify this model.
    @param nameSpace the nameSpace of the property
    @param localName the name of the property within its namespace
    @return a property instance
     */
    public Property createProperty(String nameSpace, String localName);

    /**
    Create an untyped literal from a String value with a specified language.
    @param v the lexical form of the literal
    @param language the language associated with the literal
    @return a new literal representing the value v with the given language
     */
    public Literal createLiteral(String v, String language);

//    /**
//     * @deprecated since Jena2. It is no longer legal to have a language
//     * tag on a well-formed XMLLiteral. Use the 2-argument form of
//     * {@link #createLiteral(String, boolean) createLiteral} instead.
//     *
//     *   Create a literal from a String value with a specified language. An existing literal
//     *   of the right value may be returned, or a fresh one created.
//     *  @param v the lexical form of the literal
//     *  @param language the language associated with the literal
//     *  @param wellFormed true if the Literal is well formed XML
//     *  @return a new literal representing the value v with the given language
//     */
//    public Literal createLiteral(String v, String language, boolean wellFormed);
    /**
    Create a literal from a String value. An existing literal
    of the right value may be returned, or a fresh one created.
    The use of the wellFormed flag is to create typed literals of
    type rdf:XMLLiteral, without error checking. This should
    only be use when the lexical form is known to already be
    in exclusive canonical XML.
    
    @param v the lexical form of the literal
    @param wellFormed true if the Literal is well formed XML, in the lexical space of rdf:XMLLiteral
    @return a new literal
     */
    public Literal createLiteral(String v, boolean wellFormed);

    /**
    Build a typed literal from its lexical form. The
    lexical form will be parsed now and the value stored. If
    the form is not legal this will throw an exception.
    <p>
    Note that in preview releases of Jena2 it was also possible to specify
    a language type. Changes to the RDF specification mean that this is no longer
    legal except for plain literals. To create a plain literal with a language tag
    use {@link #createLiteral(String, String) createLiteral}.
    
    @param lex the lexical form of the literal
    @param dtype the type of the literal, null for old style "plain" literals
    @throws DatatypeFormatException if lex is not a legal form of dtype
     */
//    public Literal createTypedLiteral(String lex, RDFDatatype dtype);

    /**
     * Build a typed literal from its value form.
     * <p>
     * Note that in preview releases of Jena2 it was also possible to specify
     *   a language type. Changes to the RDF specification mean that this is no longer
     *   legal except for plain literals. To create a plain literal with a language tag
     *   use {@link #createLiteral(String, String) createLiteral}.
     * </p>
     * @param value the value of the literal
     * @param dtype the type of the literal, null for old style "plain" literals
     */
//    public Literal createTypedLiteral(Object value, RDFDatatype dtype);

    /**
     * Build a typed literal label from its value form using
     * whatever datatype is currently registered as the the default
     * representation for this java class. No language tag is supplied.
     * @param value the literal value to encapsulate
     */
//    public Literal createTypedLiteral(Object value);

    /**
    Create a Statement instance. (Creating a statement does not add it to the set of
    statements in the model; see Model::add). This method may return an existing
    Statement with the correct components and model, or it may construct a fresh one,
    as it sees fit.
    <p>
    Subsequent operations on the statement or any of its parts may modify this model.
    @param s the subject of the statement
    @param p the predicate of the statement
    @param o the object of the statement
    @return the new statement
     */
    public Statement createStatement(Resource s, Property p, RDFNode o);

    /**
    Answer a new empty list. This is equivalent to a list consisting only
    of <code>rdf:nil</code>.
    @return An RDF-encoded list of no elements
     */
//    public RDFList createList();

    /**
     * <p>Answer a new list containing the resources from the given iterator, in order.</p>
     * @param members An iterator, each value of which is expected to be an RDFNode
     * @return An RDF-encoded list of the elements of the iterator
     */
//    public RDFList createList(Iterator members);

    /**
     * <p>Answer a new list containing the nodes from the given array, in order</p>
     * @param members An array of RDF nodes that will be the members of the list
     * @return An RDF-encoded list
     */
//    public RDFList createList(RDFNode[] members);

    /** Add a statement to this model.
     * @return This model.
     * @param s The statement to be added.
    
     */
    Model add(Statement s);

    /**
    Add all the statements to the Model, using through the bulk update interface.
    
    @param statements the array of statements to add
    @return this model, to allow cascading
     */
    Model add(Statement[] statements);

    /**
    Remove all the statements from the Model, using the bulk update interface.
    @param statements the array of statements to be added
    @return this model, to allow cascading
     */
    Model remove(Statement[] statements);

    /**
    add all the statements in the List to this Model, going through the bulk
    update interface (which means turning them into triples in one form or
    another).
    @param statements a List of Statements
    @return this model, to allow cascading
     */
    Model add(List statements);

    /**
    Remove all the statements in the list from this model, using the bulk
    update interface.
    @param statements a List of Statements to remove
    @return this model, to allow cascading
     */
    Model remove(List statements);

    /** Add all the statements returned by an iterator to this model.
     * @return this model
     * @param iter An iterator which returns the statements to be added.
     */
//    Model add(StmtIterator iter);

    /** Add all the statements in another model to this model, including the
     * reified statements.
     * @return this model
     * @param m The model whose statements are to be added.
     */
    Model add(Model m);

    /**
    Add all the statements of the given model m to this model.
    Optionally supress the addition of reified statements.
    @param m the model containing the statements to add
    @param suppressReifications true to suppress adding reified statements
    @return this model for cascading
     */
    Model add(Model m, boolean suppressReifications);

    /** Add the RDF statements from an XML document.
     * Uses content negotiation to request appropriate mime types.
     *
     * <p>See {@link Model} for a description of how to traverse a firewall.</p>
     * @return this model
     * @param url of the document containing the RDF statements.
    
     */
    public Model read(String url);

    /** Add statements from an RDF/XML serialization.
     * @param in the source of the RDF/XML
     * @param base the base to use when converting relative to absolute uri's.
     * The base URI may be null if there are no relative URIs to convert.
     * A base URI of "" may permit relative URIs to be used in the
     * model unconverted.
     * @return the current model
     */
    public Model read(InputStream in, String base);

    /** Add RDF statements represented in language <code>lang</code> to the model.
     * <br />Predefined values for <code>lang</code> are "RDF/XML", "N-TRIPLE"
     * and "N3".  <code>null</code> represents the default language, "RDF/XML".
     * "RDF/XML-ABBREV" is a synonym for "RDF/XML".
     * <br />
     *
     * @return this model
     * @param base the base uri to be used when converting relative
     * URI's to absolute URI's.
    The base URI may be null if there are no relative URIs to
    convert.
    A base URI of "" may permit relative URIs to be used in the
    model.
     * @param lang the langauge of the serialization <code>null</code>
     * selects the default
     * @param in the source of the input serialization
     */
    public Model read(InputStream in, String base, String lang);

    /** Using this method is often a mistake.
     * Add statements from an RDF/XML serialization.
     * It is generally better to use an InputStream if possible.
     * {@link Model#read(InputStream,String)}, otherwise there is a danger of a
     * mismatch between the character encoding of say the FileReader and the
     * character encoding of the data in the file.
     * @param reader the source of the RDF/XML
     * @param base the base to use when converting relative to absolute uri's.
    The base URI may be null if there are no relative URIs to
    convert.
    A base URI of "" may permit relative URIs to be used in the
    model.
     * * @return the current model
     */
    public Model read(Reader reader, String base);

    /**
     * Add statements from a serializion in language <code>lang</code> to the
     * model.
     * <br />Predefined values for <code>lang</code> are "RDF/XML", "N-TRIPLE"
     * and "N3".  <code>null</code> represents the default language, "RDF/XML".
     * "RDF/XML-ABBREV" is a synonym for "RDF/XML".
     * <br />
     *
     * <p>See {@link Model} for a description of how to traverse a firewall.</p>
     * @param url a string representation of the url to read from
     * @param lang the language of the serialization
    
     * @return this model
     */
    public Model read(String url, String lang);

    /** Using this method is often a mistake.
     * Add RDF statements represented in language <code>lang</code> to the model.
     *<br />
     *Predefined values for <code>lang</code> are "RDF/XML", "N-TRIPLE"
     *and "N3".  <code>null</code> represents the default language, "RDF/XML".
     *"RDF/XML-ABBREV" is a synonym for "RDF/XML".
     * <br />
     * It is generally better to use an InputStream if possible.
     * {@link Model#read(InputStream,String)}, otherwise there is a danger of a
     * mismatch between the character encoding of say the FileReader and the
     * character encoding of the data in the file.
     * @return this model
     * @param base the base uri to be used when converting relative
     * URI's to absolute URI's.
    
    The base URI may be null if there are no relative URIs to
    convert.
    A base URI of "" may permit relative URIs to be used in the
    model.
    
     * @param lang the langauge of the serialization <code>null</code>
     * selects the default
     * @param reader the source of the input serialization
     */
    public Model read(Reader reader, String base, String lang);

    /**
    Read into this model the RDF at <code>url</code>, using
    <code>baseURI</code> as the base URI if it is non-null. The RDF is assumed
    to be RDF/XML unless <code>lang</code> is non-null, in which case it names
    the language to be used. Answer this model.
     */
    Model read(String url, String base, String lang);

    // output operations
    /**
     * <p>Write the model as an XML document.
     * It is often better to use an OutputStream rather than a Writer, since this
     * will avoid character encoding errors.
     * </p>
     *
     * @param writer A writer to which the XML will be written
     * @return this model
     */
    public Model write(Writer writer);

    /**
     * <p>Write a serialized represention of a model in a specified language.
     * It is often better to use an OutputStream rather than a Writer, since this
     * will avoid character encoding errors.
     * </p>
     * <p>The language in which to write the model is specified by the
     * <code>lang</code> argument.  Predefined values are "RDF/XML",
     * "RDF/XML-ABBREV", "N-TRIPLE" and "N3".  The default value,
     * represented by <code>null</code> is "RDF/XML".</p>
     * @param writer The output writer
     * @param lang The output language
     * @return this model
     */
    public Model write(Writer writer, String lang);

    /**
     * <p>Write a serialized represention of a model in a specified language.
     * It is often better to use an OutputStream rather than a Writer,
     * since this will avoid character encoding errors.
     * </p>
     * <p>The language in which to write the model is specified by the
     * <code>lang</code> argument.  Predefined values are "RDF/XML",
     * "RDF/XML-ABBREV", "N-TRIPLE" and "N3".  The default value,
     * represented by <code>null</code>, is "RDF/XML".</p>
     * @param writer The output writer
     * @param base The base uri for relative URI calculations.
     * <code>null</code> means use only absolute URI's.
     * @param lang The language in which the RDF should be written
     * @return this model
     */
    public Model write(Writer writer, String lang, String base);

    /**
     * <p>Write a serialization of this model as an XML document.
     * </p>
     * <p>The language in which to write the model is specified by the
     * <code>lang</code> argument.  Predefined values are "RDF/XML",
     * "RDF/XML-ABBREV", "N-TRIPLE" and "N3".  The default value is
     * represented by <code>null</code> is "RDF/XML".</p>
     * @param out The output stream to which the XML will be written
     * @return This model
     */
    public Model write(OutputStream out);

    /**
     * <p>Write a serialized represention of this model in a specified language.
     * </p>
     * <p>The language in which to write the model is specified by the
     * <code>lang</code> argument.  Predefined values are "RDF/XML",
     * "RDF/XML-ABBREV", "N-TRIPLE" and "N3".  The default value,
     * represented by <code>null</code>, is "RDF/XML".</p>
     * @param out The output stream to which the RDF is written
     * @param lang The output langauge
     * @return This model
     */
    public Model write(OutputStream out, String lang);

    /**
     * <p>Write a serialized represention of a model in a specified language.
     * </p>
     * <p>The language in which to write the model is specified by the
     * <code>lang</code> argument.  Predefined values are "RDF/XML",
     * "RDF/XML-ABBREV", "N-TRIPLE" and "N3".  The default value,
     * represented by <code>null</code>, is "RDF/XML".</p>
     * @param out The output stream to which the RDF is written
     * @param base The base uri to use when writing relative URI's. <code>null</code>
     * means use only absolute URI's. This is used for relative
     * URIs that would be resolved against the document retrieval URL.
     * For some values of <code>lang</code>, this value may be included in the output. 
     * @param lang The language in which the RDF should be written
     * @return This model
     */
    public Model write(OutputStream out, String lang, String base);

    /** Removes a statement.
     *
     * <p> The statement with the same subject, predicate and object as
     *     that supplied will be removed from the model.</p>
     * @return this model
     * @param s The statement to be removed.
    
     */
    Model remove(Statement s);

    /** Return a statement with given subject and property.
     *  <p>If more than one statement witht the given subject and property
     *  exists in the model, it is undefined which will be returned. If none
     * exist, an exception is thrown.
     * @return A statement from the model with the given subject and property.
     * @param s The subject of the statement to be returned.
     * @param p The property of the statement to be returned.
     * @throws PropertyNotFoundException
     */
    Statement getRequiredProperty(Resource s, Property p);

    /**
    Answer a statement (s, p, ?O) from this model. If none exist, return null;
    if several exist, pick one arbitrarily.
    @param s the subject of the statement to return
    @param p the predicate of the statement to return
    @return some statement (s, p, ?O) or null if none can be found
     */
    Statement getProperty(Resource s, Property p);

    /** 
    An alias for <code>istResourcesWithProperty(Property)</code>,
    retained for backward compatability. It may be deprecated in later
    releases.
     */
//    ResIterator listSubjectsWithProperty(Property p);

    /**
    Answer an iterator [with no duplicates] over all the resources in this 
    model that have property <code>p</code>. <code>remove()</code>
    is not implemented on this iterator.
     */
//    ResIterator listResourcesWithProperty(Property p);

    /** 
    An alias for <code>listResourcesWithProperty</code>, retained for
    backward compatability. It may be deprecated in later releases.
     */
//    ResIterator listSubjectsWithProperty(Property p, RDFNode o);

    /**
    Answer an iterator [with no duplicates] over all the resources in this 
    model that have property <code>p</code> with value <code>o</code>.
    <code>remove()</code> is not implemented on this iterator. 
     */
//    ResIterator listResourcesWithProperty(Property p, RDFNode o);

    /** List all objects in a model.
     * @return an iterator over the objects.  .remove() is not implemented on this iterator.
     */
//    NodeIterator listObjects();

    /** List all objects of a given property.  .remove() is not implemented on this iterator.
     * @return an iterator over the objects
     * @param p The predicate sought
     */
//    NodeIterator listObjectsOfProperty(Property p);

    /** List the values of a property of a resource.
     * @return an iterator over the objects.  .remove() is not implemented on this iterator.
     * @param p The predicate sought
     */
//    NodeIterator listObjectsOfProperty(Resource s, Property p);

    /** Determine whether this model contains any statements with a given subject
     *  and property.
     * @return true if there exists within this model a statement with
     * subject s and property p, false otherwise
     * @param s The subject sought (null for any).
     * @param p The predicate sought (null for any).
    
     */
    boolean contains(Resource s, Property p);

    /**
    determine if the RDFNode r appears in any statement of this model.
    (containsRDFNode is a horrible name, and in any case, even literals
    will be resources one day)
    
    @param r the RDFNode to be searched for
    @return true iff r appears as some subject, predicate, or object
     */
    boolean containsResource(RDFNode r);

    /** Determine if an (S, P, O) pattern is present in this model, with null allowed
     * to represent a wildcard match.
     * @return true if the statement with subject s, property p and object o
     * is in the model, false otherwise
     * @param s The subject of the statment tested (null as wildcard).
     * @param p The predicate of the statement tested (null as wildcard).
     * @param o The object of the statement tested (null as wildcard).
    
     */
    boolean contains(Resource s, Property p, RDFNode o);

    /** Determine if a statement is present in this model.
     * @param s The statement tested.
    
     * @return true if the statement s is in this model, false otherwise
     */
    boolean contains(Statement s);

    /** Determine if any of the statements returned by an iterator are
     * contained in this model.
     * @param iter an iterator of the statements to be tested
    
     * @return true if any of the statements returns by iter are contained
     *         in this model and false otherwise.
     */
//    boolean containsAny(StmtIterator iter);

    /** Determine if all of the statements returned by an iterator are
     * contained in this model.
     * @param iter an iterator of the statements to be tested
    
     * @return true if any of the statements returns by iter are contained
     *         in this model and false otherwise.
     */
//    boolean containsAll(StmtIterator iter);

    /** Determine if any of the statements in a model are also contained
     *  in this model.
     * @param model the model containing the statements to be tested
    
     * @return true if any of the statements in model are also contained
     *         in this model and false otherwise.
     */
    boolean containsAny(Model model);

    /** Determine if all of the statements in a model are also contained
     *  in this model.
     * @param model the model containing the statements to be tested
    
     * @return true if all of the statements in model are also contained
     *         in this model and false otherwise.
     */
    boolean containsAll(Model model);

    /**
    Determine if this Statement has been reified in this Model.
    
    @param s The statement tested.
    @return true iff a ReifiedStatement(s) has been created in this model
     */
    boolean isReified(Statement s);

    /**
    Find or create a {@link ReifiedStatement} corresponding to a Statement.
    @param s Statement which may or may not already be reified
    @return a Resource [ReifiedStatement] that reifies the specified Statement.
     */
    Resource getAnyReifiedStatement(Statement s);

    /**
    Remove all reifications (ie implicit reification quads) of _s_.
     */
    void removeAllReifications(Statement s);

    /**
    Remove a particular reificiation.
     */
//    void removeReification(ReifiedStatement rs);

    /** List all statements.
     *
     *  <p>Subsequent operations on those statements may modify this model.</p>
    
     * @return an iterator over all statements in the model.
     */
    StmtIterator listStatements();

    /** List the statements matching a selector.
     *
     * <p>A statment is considered to match if the <CODE>test</CODE> method
     * of s returns true when called on s.</p>
     * @return an iterator over the matching statements
     * @param s A selector object.
    .
     */
//    StmtIterator listStatements(Selector s);

    /** Find all the statements matching a pattern.
     * <p>Return an iterator over all the statements in a model
     *  that match a pattern.  The statements selected are those
     *  whose subject matches the <code>subject</code> argument,
     *  whose predicate matches the <code>predicate</code> argument
     *  and whose object matches the <code>object</code> argument.
     *  If an argument is <code>null</code> it matches anything.</p>
     * @return an iterator over the subjects
     * @param s   The subject sought
     * @param p The predicate sought
     * @param o    The value sought
     */
    StmtIterator listStatements(Resource s, Property p, RDFNode o);

    /**
    Answer a ReifiedStatement that encodes _s_ and belongs to this Model.
    <br>
    result.getModel() == this
    <br>
    result.getStatement() .equals ( s )
     */
//    ReifiedStatement createReifiedStatement(Statement s);

    /**
    answer a ReifiedStatement that encodes _s_, belongs to this Model,
    and is a Resource with that _uri_.
     */
//    ReifiedStatement createReifiedStatement(String uri, Statement s);

    /**
    answer an iterator delivering all the reified statements "in" this model
     */
//    RSIterator listReifiedStatements();

    /**
    answer an iterator delivering all the reified statements "in" this model
    that match the statement _st_.
     */
//    RSIterator listReifiedStatements(Statement st);

    /**
    Answer the reification style of the model.
    @return the reification style
     */
//    ReificationStyle getReificationStyle();

    /** Create a new model containing the statements matching a query.
     *
     * <p>A statment is considered to match if the <CODE>test</CODE> method
     * of s returns true when called on s.</p>
     * @return an iterator over the matching statements
     * @param s A selector object.
    .
     */
//    Model query(Selector s);

    /** 
    Create a new, independant, model containing all the statements in this model
    together with all of those in another given model. By <i>independant</i>
    we mean that changes to the result model do not affect the operand
    models, and <i>vice versa</i>.
    <p>
    The new model need not be of the same type as either this model or
    the argument model: typically it will be a memory-based model, even
    if this model is a database model.
    
    @return A new model containing all the statements that are in either model
    @param model The other model whose statements are to be included.
     */
    Model union(Model model);

    /** 
    Create a new, independant, model containing all the statements which are in both
    this model and another.  As models are sets of statements, a statement
    contained in both models will only appear once in the resulting model.
    The new model need not be of the same type as either this model or
    the argument model: typically it will be a memory-based model.
    
    @return A new model containing all the statements that are in both models.
    @param model The other model.
     */
    Model intersection(Model model);

    /** Create a new, independant, model containing all the statements in this model which
     * are not in another.
    The new model need not be of the same type as either this model or
    the argument model: typically it will be a memory-based model.
     * @return a new model containing all the statements in this model that
     *         are not in the given model.
     * @param model the other model whose statements are to be excluded.
    
     */
    Model difference(Model model);

    /**
     * Test whether the given object <code>m</code>
     * is a model that is equal to this model,
     * which is true iff the underlying graphs are identical Java
     * objects. This is not the same test as comparing whether two models
     * have the same structure (i.e. contain the same set of statements).
     * To test for strucutural equivalence, see {@link #isIsomorphicWith}.
     * @param m the model to be compared
     * @return true if <code>m</code> shares a graph object with this model
     * @see #isIsomorphicWith(Model)
     */
    @Override
    public boolean equals(Object m);

    /** Begin a new transation.
     *
     * <p> All changes made to a model within a transaction, will either
     * be made, or none of them will be made.</p>
     * @return this model to enable cascading.
    
     */
    Model begin();

    /** Abort the current transaction and abandon any changes in progress.
     * @return this model to enable cascading.
    
     */
    Model abort();

    /** Commit the current transaction.
     * @return this model to enable cascading.
    
     */
    Model commit();

    /**
    Execute the command <code>cmd</code> inside a transaction. If it
    completes, commit the transaction and return the result; if it fails
    (by throwing an exception), abort the transaction and throw an
    exception.
     */
//    Object executeInTransaction(Command cmd);

    /** Determine whether this model is independent.
     *
     *  <p>For efficiency reasons, some implementations may create models which
     *  which are dependent on others, i.e. a change in one model may cause
     *  a change in another.  If this is the case this method will return false,
     *  otherwise it will return true.</p>
     *
     * @return  true if this model is indepdent of others
     */
    boolean independent();

    /** Determine whether this model supports transactions.
     * @return  true if this model supports transactions.
     */
    boolean supportsTransactions();

    /** Determine whether this model supports set operations.
     * @return true if this model supports set operations.
     */
    boolean supportsSetOperations();

    /**
     * Compare this Model with another for equality ignoring the labels on
     * bNodes.
     * See
     * <a href="http://www.w3.org/TR/rdf-concepts#section-Graph-syntax">RDF
     * Concepts</a>.
     * <p>Two models are isomorphic when each statement in one can be matched
     * with a statement in the other.  Statements which are identical match.</p>
     *
     * <p>Special treatment is given to anonymous nodes.  A binding is a one to
     * one mapping which maps each anonymous node in <code>this</code> model to
     * an anonymous node in <code>model</code>.  Two statements s1 and s2 match
     * under a binding if if s1.subject is anonymous and s2.subject is anonymous
     * and the binding maps s1.subject to s2.subject.</p>
     *
     * <p>Two models are isomorphic if there is a binding that allows all the
     * statements in one model to match a a statement in the other.</p>
     * @param g Compare against this.
     * @return boolean True if the two RDF graphs are isomorphic.
     */
    boolean isIsomorphicWith(Model g);

    /** Close the Model and free up resources held.
     *
     *  <p>Not all implementations of Model require this method to be called.  But
     *     some do, so in general its best to call it when done with the object,
     *     rather than leave it to the finalizer.</p>
     */
    public void close();

//    /** Get the model lock for this model.
//     *  See also the convenience operations enterCriticalSection and leaveCriticalSection.
//     *
//     * @see ModelLock
//     * @return The ModelLock object associated with this model
//     * @deprecated Applications should use {@link #getLock()}
//     */
//    public ModelLock getModelLock() ;
    /** Get the model lock for this model.
     *  See also the convenience operations enterCriticalSection and leaveCriticalSection.
     *
     * @see ModelLock
     * @return The ModelLock object associated with this model
     */
//    public Lock getLock();

    /**
    Register a listener for model-changed events on this model. The methods on
    the listener will be called when API add/remove calls on the model succeed
    [in whole or in part].
    <p>
    The same listener may be registered many times; if so, it's methods will
    be called as many times as it's registered for each event.
    
    @see ModelChangedListener
    @return this model, for cascading
     */
//    public Model register(ModelChangedListener listener);

    /**
    Unregister a listener from model-changed events on this model. The
    listener is dtached from the model. The model is returned to permit
    cascading. If the listener is not attached to the model, then nothing happens.
    
    @see ModelChangedListener
    @return this model, for cascading
     */
//    public Model unregister(ModelChangedListener listener);

    /**
    Notify any listeners that the event e has occurred.
    @param e the event that has occurred
     */
    public Model notifyEvent(Object e);

    /**
    Remove all the statements from this model.
     */
    public Model removeAll();

    /**
    Remove all the statements matching (s, p, o) from this model.
     */
    public Model removeAll(Resource s, Property p, RDFNode r);

    /**
    Answer true iff .close() has been called on this Model.
     */
    public boolean isClosed();
}
