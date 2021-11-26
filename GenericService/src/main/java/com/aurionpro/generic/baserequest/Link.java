/**
 * 
 */
package com.aurionpro.generic.baserequest;

import java.io.Serializable;

/**
 * The Class Link.
 *
 * @author bhanu.shukla
 */
public class Link implements Serializable, Comparable<Link> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 853434340316792588L;

	private Integer index;

	/** The display name. */
	private String displayName;

	/** The icon. */
	private String icon;

	/** The url. */
	private String url;

	/** The on click. */
	private String onClick;

	public Link(Integer index) {
		if (null == index) {
			this.index = 0;
		} else {
			this.index = index;
		}
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * Sets the icon.
	 *
	 * @param icon
	 *            the new icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the on click.
	 *
	 * @return the on click
	 */
	public String getOnClick() {
		return onClick;
	}

	/**
	 * Sets the on click.
	 *
	 * @param onClick
	 *            the new on click
	 */
	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(Link o) {
		// TODO Auto-generated method stub
		return this.index.compareTo(o.index);
	}

}
