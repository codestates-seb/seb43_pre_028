import React from 'react';
import { ReactComponent as StackoverFlowSVG } from '../../assets/img/stackoverflow-color.svg';
import ListItem from './ListItem';
import CopyRight from './CopyRight';
import Logo from './Logo';

export default function Footer() {
  const stackoverflow = {
    headerName: 'STACK OVERFLOW',
    listNames: ['Questions', 'Help'],
  };
  const product = {
    headerName: 'PRODUCTS',
    listNames: ['Teams', 'Advertising', 'Collectives', 'Talent'],
  };

  const company = {
    headerName: 'COMPANY',
    listNames: [
      'About',
      'Press',
      'Work Here',
      'Legal',
      'Privacy Policy',
      'Terms of Service',
      'Contact Us',
      'Cookie Settings',
      'Cookie Policy',
    ],
  };

  const network = {
    headerName: 'STACK EXCHANGE NETWORK',
    listNames: [
      'Technology',
      'Culture & recreation',
      'Life & arts',
      'Science',
      'Professional',
      'Business',
      'API',
      'Data',
    ],
  };
  return (
    <div className="flex justify-center items-center h-[320px] w-screen bg-footer-bg text-footer-text">
      <div className="flex max-w-[1240px] w-full px-3 pt-8 pb-3">
        <Logo />
        <nav className="flex w-3/4">
          <ListItem type="stackoverflow" {...stackoverflow} />
          <ListItem type="product" {...product} />
          <ListItem type="company" {...company} />
          <ListItem type="network" {...network} />
        </nav>
        <CopyRight />
      </div>
    </div>
  );
}
