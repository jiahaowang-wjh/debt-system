package com.smart.bracelet.userdetails;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * TODO: 描述信息
 *
 * @author junyunxiao
 * @version 1.0
 * @date 2019/7/10 11:11
 */
public class CustomUserInfo implements UserDetails, CredentialsContainer, Serializable {

    private static final long serialVersionUID = 5272236142014645518L;

    private String userInfoId;

    private final String username;

    private final String name;

    private String password;

    private final String userAvatar;

    private final boolean enabled;

    private final boolean accountNonExpired;

    private final boolean credentialsNonExpired;

    private final boolean accountNonLocked;

    private final Collection<? extends GrantedAuthority> authorities;
    
    public CustomUserInfo(String userInfoId, String username, String name, String password, String userAvatar, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        if (username != null && !"".equals(username) && password != null) {
        this.userInfoId = userInfoId;
        this.username = username;
        this.name = name;
        this.password = password;
        this.userAvatar = userAvatar;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getName() {
        return this.name;
    }

    public String getUserInfoId() {
        return this.userInfoId;
    }

    public String getUserAvatar() {
        return this.userAvatar;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet(new AuthorityComparator());
        Iterator var2 = authorities.iterator();

        while (var2.hasNext()) {
            GrantedAuthority grantedAuthority = (GrantedAuthority) var2.next();
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }


    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
        private static final long serialVersionUID = 510L;

        private AuthorityComparator() {
        }

        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {
                return -1;
            } else {
                return g1.getAuthority() == null ? 1 : g1.getAuthority().compareTo(g2.getAuthority());
            }
        }
    }

    @Override
    public boolean equals(Object rhs) {
        return rhs instanceof User ? this.username.equals(((User) rhs).getUsername()) : false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }
}
