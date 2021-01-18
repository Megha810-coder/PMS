interface NavAttributes {
  [propName: string]: any;
}
interface NavWrapper {
  attributes: NavAttributes;
  element: string;
}
interface NavBadge {
  text: string;
  variant: string;
}
interface NavLabel {
  class?: string;
  variant: string;
}

export interface NavData {
  name?: string;
  url?: string;
  icon?: string;
  badge?: NavBadge;
  title?: boolean;
  children?: NavData[];
  variant?: string;
  attributes?: NavAttributes;
  divider?: boolean;
  class?: string;
  label?: NavLabel;
  wrapper?: NavWrapper;
}

export const navItems: NavData[] = [
  {
    name: '',
    url: '/dashboard',
    icon: '',
    badge: {
      variant: 'info',
      text: ''
    }
  },
//   {
//     name: 'Recrutment',
//     url: '/Recrutment',
//     icon: 'icon-speedometer',
//     badge: {
//       variant: 'info',
//       text: 'NEW'
//     }
//   },
//   {
//   name: 'VMS',
//   url: '/neha',
//   icon: 'icon-list',
//   children: [
//     {
//       name: 'Events',
//       url: '/neha/Events'
     
//     }, 

//   ]
// },

// {
//   name: 'Induction_Training',
//   url: '/induction',
//   icon: 'icon-list',
//   children: [
//     {
//       name: 'Induction',
//       icon: 'icon-user',
//       url: '/induction/Induction-form'
     
//     }, 
//   ]
// },

// {
//   name: 'Appraisal_Form',
//   url: '/induction',
//   icon: 'icon-list',
//   children: [
//     {
//       name: 'Appraisal',
//       icon: 'icon-user',
//       url: '/induction/Appraisal-Form'
     
//     }, 
//   ]
// },


 {
   name: 'Product-Mng',
   url: '/neha',
   icon: 'icon-list',
   children: [
     {
       name: 'Product',
       icon: 'icon-user',
       url: '/neha/Product'
     
     }, 
     {
       name: 'Packeging',
       icon: 'icon-user',
       url: '/neha/Packeging'
     
     }, 
     {
       name: 'Delivery',
       icon: 'icon-user',
       url: '/neha/Vehicle'
     
     }, 
     {
       name: 'Scrap',
       icon: 'icon-user',
       url: '/neha/Scrap'
     
     }, 
     {
       name: 'bill',
       icon: 'icon-user',
       url: '/neha/bill'
     
     }, 
   ]
 },

// {
//   name: 'EHS',
//   url: '/ehs',
//   icon: 'icon-list',
//   children: [
//     {
//       name: 'Waste Management',
//       url: '/ehs/Waste Management'
     
//     }, 

//     {
//       name: 'Hazardous Management',
//       url: '/ehs/Hazardous Management'
     
//     }, 

//   ]
// },

// {
//   name: 'Labour Contract Management',
//   url: '/lcm',
//   icon: 'icon-list',
//   children: [
//     {
//       name: 'Contractor List',
//       icon: 'icon-user',
//       url: '/lcm/Contractor List'
     
//     }, 

//     {
//       name: 'Manual Labour Check',
//       icon: 'icon-user',
//       url: '/lcm/Manual Labour Check'
     
//     }, 
//   ]
// },

];
