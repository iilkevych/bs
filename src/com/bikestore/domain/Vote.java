package com.bikestore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "VOTES")
public class Vote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9139728964218067299L;

	@Id
	@Column(name = "ACCOUNT_ID")
	private Long id;

	@OneToOne
	@PrimaryKeyJoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@OneToOne
	@JoinColumn(name = "MENU_ID")
	private Menu menu;

	public Vote() {
	}

	public Vote(Account account, Menu menu) {
		this.account = account;
		this.id = account.getId();
		this.menu = menu;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		this.id = account.getId();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
