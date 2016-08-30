/*
 * Copyright 2016 Cognifide Ltd..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognifide.qa.bb.aem.touch.siteadmin.aem61.list;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.touch.siteadmin.common.SiteadminChildPage;
import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class ChildPageRow implements SiteadminChildPage {

  @CurrentScope
  @Inject
  private WebElement currentScope;

  @FindBy(css = "i.select")
  private WebElement checkBox;

  @FindBy(css = "div.main > h4.foundation-collection-item-title")
  private WebElement titleBar;

  @FindBy(css = "div.info > p.modified")
  private PageModificationInfoImpl pageModificationInfo;

  @FindBy(css = "div.info > p.published")
  private PageActivationStatusImpl pageActivationStatus;

  @FindBy(tagName = "a")
  private WebElement anchor;

  @Override
  public String getTitle() {
    return titleBar.getText();
  }

  @Override
  public ChildPageRow select() {
    checkBox.click();
    return this;
  }

  @Override
  public String getHref() {
    return anchor.getAttribute("href");
  }

  @Override
  public PageModificationInfoImpl getModificationInfo() {
    return pageModificationInfo;
  }

  @Override
  public PageActivationStatusImpl getPageActivationStatus() {
    return pageActivationStatus;
  }

  @Override
  public void click() {
    currentScope.click();
  }

}
