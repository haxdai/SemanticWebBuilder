package org.semanticwb.ecosikan.innova;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.ChallengeManager.Phases;
import org.semanticwb.ecosikan.innova.IdeaManager.IdeaStatus;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;


public class Idea extends org.semanticwb.ecosikan.innova.base.IdeaBase {
    private static Logger log = SWBUtils.getLogger(Idea.class);
    static private HashMap<String,HashMap> hashPrim = new HashMap();
    public static final int List_Last = 3;

    public Idea(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void addData(String title, String description, WebPage parent) throws IllegalArgumentException {
        if(title==null || "".equals(title)) {
            throw new IllegalArgumentException("El t&iacute;tulo de la idea es requerido");
        }
        if(description==null || "".equals(description)) {
            throw new IllegalArgumentException("La descripci&oacute;n de la idea es requerida");
        }
        if(parent==null) {
            throw new IllegalArgumentException("La p&aacute;gina padre de la idea es requerida");
        }
        setTitle(title);
        setDescription(description);
        setStatus(IdeaStatus.Opened.name());
        setSelected(false);
        setWp(parent);
    }

    public boolean edit(final User user) {
        boolean suc = Boolean.FALSE;
        WebPage parent = getWp();
        if(parent instanceof Theme &&  userCanEdit(user)) {
            try {
                IdeaStatus status = IdeaStatus.valueOf(getStatus());
                if(status.hasNext()) {
                    setStatus(status.next().name());
                    suc = Boolean.TRUE;
                }
            }catch(IllegalArgumentException iae) {
                log.error(iae);
            }
        }
        return suc;
    }

    public boolean vote(final String ipAddress, final String votefor) {
        boolean suc = Boolean.FALSE;
        try {
            IdeaStatus status = IdeaStatus.valueOf(getStatus());
            if( IdeaStatus.Opened==status && canIPAddressVote(ipAddress) && votefor!=null && !votefor.isEmpty() ) {
                if("u".equals(votefor)) { // votar por me gusta (u p)
                    setVotesP(getVotesP()+1);
                    suc = Boolean.TRUE;
                }else if ("d".equals(votefor)) { // votar por no me gusta (d own)
                    setVotesN(getVotesN()+1);
                    suc = Boolean.TRUE;
                }
            }
        }catch(IllegalArgumentException iae) {
            log.error(iae);
        }
        return suc;
    }

    public void comment(final String text) {
        try {
            IdeaStatus status = IdeaStatus.valueOf(getStatus());
            WebPage parent = getWp();
            if( parent instanceof Theme && IdeaStatus.Opened==status && text!=null && !text.isEmpty() ) {
                Comment comment = Comment.ClassMgr.createComment(parent.getWebSite());
                comment.setText(text);
                addComment(comment);
                ((Theme)parent).offer(comment);
                ((Dependencia)parent.getParent()).offer(comment);
            }else if( parent instanceof Challenge && text!=null && !text.isEmpty() ) {
                Challenge challenge = (Challenge)parent;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if(Phases.Opened==phase) {
                    Comment comment = Comment.ClassMgr.createComment(parent.getWebSite());
                    comment.setText(text);
                    addComment(comment);
                    challenge.offer(comment);
                    ((Dependencia)parent.getParent()).offer(comment);
                }
            }
        }catch(IllegalArgumentException iae) {
            log.error(iae);
        }
    }

    public boolean categorize(String categoryId) {
        boolean suc = Boolean.FALSE;
        try {
            WebPage parent = getWp();
            if( parent instanceof Challenge && categoryId!=null && !categoryId.isEmpty() ) {
                Challenge challenge = (Challenge)parent;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if( Phases.Categorizing==phase ) {////////
                    Category category = Category.ClassMgr.getCategory(categoryId, parent.getWebSite());
                    if(category!=null) {
                        setCategory(category);
                        suc = Boolean.TRUE;
                    }
                }/////////////////////////////////////////
            }
        }catch(IllegalArgumentException iae) {
            log.error(iae);
        }
        return suc;
    }

    public boolean select(boolean selected) {
        boolean suc = Boolean.FALSE;
        try {
            WebPage parent = getWp();
            if( parent instanceof Challenge ) {
                Challenge challenge = (Challenge)parent;
                Phases phase = Phases.valueOf(challenge.getPhase());
                if( Phases.Selecting==phase ) {////////
                    setSelected(selected);
                }//////////////////////////////////////
            }
        }catch(IllegalArgumentException iae) {
            log.error(iae);
        }
        return suc;
    }

    private boolean canIPAddressVote(String ipAddress) {
        boolean canIPVote = Boolean.TRUE;
        int hrs=24;
//        try {
//            hrs = Integer.parseInt(getResourceBase().getAttribute("time", "24"));
//        }catch(Exception e) {
//            hrs=24;
//        }
        System.out.println("\n\nip="+ipAddress+", ideaId="+getId());


        GregorianCalendar t1= new GregorianCalendar();
        GregorianCalendar t2= new GregorianCalendar();
        //t2.add(GregorianCalendar.HOUR, hrs);
        t2.add(GregorianCalendar.MINUTE, 5);

        if(hashPrim.containsKey(ipAddress)) {
            System.out.println("ya existe ip");
            HashMap<String,Long> i = hashPrim.get(ipAddress);
            if(i.containsKey(getId())) {
                System.out.println("idea ya registrada");
                long ipdate = i.get(getId());
                if(ipdate>t1.getTimeInMillis()) {
                    canIPVote = Boolean.FALSE;
                    System.out.println("no se puede votar aun");
                }else {
                    i.remove(getId());
                    /*if(i.isEmpty())
                        hashPrim.remove(ipAddress);*/
                    System.out.println("votar en posible y no quitamos nada");
                }
            }else {
                i.put(getId(), t2.getTimeInMillis());
                System.out.println("idea no registrada... votemos");
            }
        }else {
            System.out.println("ip no registrada");
            HashMap<String,Long> i = new HashMap();
            i.put(getId(), t2.getTimeInMillis());
            hashPrim.put(ipAddress, i);
            System.out.println("votar en posible");
        }
        return canIPVote;
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }
    
    public static class IdeasSortByPositiveVotes implements Comparator<Idea>{
        public int compare(Idea idea1, Idea idea2) {
            return new Long(idea1.getVotesP()).compareTo(new Long(idea2.getVotesP()));
        }
    }

    public static class IdeasSortByCreatedDate implements Comparator<Idea>{
        public int compare(Idea idea1, Idea idea2) {
            return idea1.getCreated().compareTo( idea2.getCreated() );
        }
    }
}
